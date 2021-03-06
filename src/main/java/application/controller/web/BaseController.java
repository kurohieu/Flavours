package application.controller.web;
import application.data.model.*;
import application.data.service.CartService;
import application.data.service.SaleProductService;
import application.model.viewmodel.cart.CartProductVM;
import application.model.viewmodel.cart.CartVM;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class BaseController {
    private static final Logger logger = LogManager.getLogger(CartController.class);

    @Autowired
    private CartService cartService;

    @Autowired
    private SaleProductService saleProductService;


    public void checkCookie(HttpServletResponse response,
                            HttpServletRequest request,
                            final Principal principal) {
        Cookie cookie[] = request.getCookies();


        if(principal!= null) {
            String  username = SecurityContextHolder.getContext().getAuthentication().getName();
            Cart cartEntity = cartService.findByUserName(username);
            if(cartEntity != null) {
                Cookie cookie1 = new Cookie("guid",cartEntity.getGuid());
                cookie1.setPath("/");
                cookie1.setMaxAge(60*60*24);
                response.addCookie(cookie1);
            } else {
                UUID uuid = UUID.randomUUID();
                String guid = uuid.toString();
                Cart cart = new Cart();
                cart.setGuid(guid);
                cart.setUserName(username);
                cartService.addNewCart(cart);

                Cookie cookie2 = new Cookie("guid",guid);
                cookie2.setPath("/");
                response.addCookie(cookie2);
            }
        } else {
            boolean flag2 = true;

            String guid = null;

            if(cookie!=null) {
                for(Cookie c : cookie) {
                    if(c.getName().equals("guid")) {
                        flag2 = false;
                        guid = c.getValue();
                    }
                }
            }

            if(flag2 == true) {
                UUID uuid = UUID.randomUUID();
                String guid2 = uuid.toString();
                Cart cart2 = new Cart();
                cart2.setGuid(guid2);
                cartService.addNewCart(cart2);

                Cookie cookie3 = new Cookie("guid",guid2);
                cookie3.setPath("/");
                cookie3.setMaxAge(60*60*24);
                response.addCookie(cookie3);

            } else {
                Cart cartEntity = cartService.findFirstCartByGuid(guid);
                if(cartEntity == null) {
                    Cart cart3 = new Cart();
                    cart3.setGuid(guid);
                    cartService.addNewCart(cart3);
                }
            }

        }
    }

    public CartVM setCartVM(String guid){

        CartVM cartVM = new CartVM();

        int productAmount = 0;
        double totalPrice = 0;
        List<CartProductVM> cartProductVMs = new ArrayList<>();

        DecimalFormat df = new DecimalFormat("##,###,###");

        try {
            if(guid != null) {
                Cart cartEntity = cartService.findFirstCartByGuid(guid);
                if(cartEntity != null) {
                    for(CartProduct cartProduct : cartEntity.getCartProducts()) {
                        CartProductVM cartProductVM = new CartProductVM();
                        cartProductVM.setId(cartProduct.getId());
                        cartProductVM.setProductId(cartProduct.getProduct().getId());
                        cartProductVM.setProductName(cartProduct.getProduct().getName());
                        cartProductVM.setMainImage(cartProduct.getProduct().getMainImage());
                        cartProductVM.setAmount(cartProduct.getAmount());
                        double price;
                        if (cartProduct.getProduct().getPrice()!=setPriceVM(cartProduct.getProduct())){
                            cartProductVM.setHasSale(true);
                            cartProductVM.setPriceSaleProduct(df.format(setPriceVM(cartProduct.getProduct())));
                            cartProductVM.setPriceSale(df.format(cartProduct.getAmount()*setPriceVM(cartProduct.getProduct())));
                            price = cartProduct.getAmount()*setPriceVM(cartProduct.getProduct());
                            cartProductVM.setPrice(df.format(price));
                        }else {
                            cartProductVM.setHasSale(false);
                            price = cartProduct.getAmount()*cartProduct.getProduct().getPrice();
                            cartProductVM.setPrice(df.format(price));
                        }

                        totalPrice += price;
                        productAmount += cartProduct.getAmount();
                        cartProductVM.setPriceProduct(df.format(cartProduct.getProduct().getPrice()));
                        cartProductVMs.add(cartProductVM);
                    }
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }


        cartVM.setProductAmount(productAmount);
        cartVM.setCartProductVMs(cartProductVMs);
        cartVM.setTotalPrice(df.format(totalPrice));

        return cartVM;
    }
    public String getGuid(HttpServletRequest request) {
        Cookie cookie[] = request.getCookies();

        if(cookie!=null) {
            for(Cookie c :cookie) {
                if(c.getName().equals("guid"))  return c.getValue();
            }
        }
        return null;
    }
    public Double setPriceVM(Product product){
        SaleProduct saleProduct = saleProductService.findSaleProductByProductIdAndCurrentDate(product.getId(),new Date());

        if (saleProduct!= null){
            Sale sale = saleProduct.getSale();
            Double priceSale = product.getPrice()-product.getPrice()*sale.getSalePercent()/100-sale.getSaleMoney();
            if (priceSale<=0){
                return product.getPrice();
            }
            else return priceSale;
        }

        return product.getPrice();
    }

}
