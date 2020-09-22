package application.controller.web;

import application.data.model.*;
import application.data.service.CartService;
import application.data.service.ProductService;
import application.model.viewmodel.cart.CartVM;
import application.model.viewmodel.common.ProductVM;
import application.model.viewmodel.home.HomeLandingVM;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.security.Principal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller

public class HomeController extends BaseController{
    private static final Logger logger = LogManager.getLogger(OrderController.class);

    @Autowired
    private ProductService productService;
    @Autowired
    private CartService cartService;


    @GetMapping("")
    public String home(Model model,
                       @Valid @ModelAttribute("product") ProductVM product,
                       HttpServletResponse response,
                       HttpServletRequest request,
                       final Principal principal) {
        this.checkCookie(response, request, principal);

        HomeLandingVM vm = new HomeLandingVM();
        DecimalFormat df = new DecimalFormat("##,###,###");
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        String guid = getGuid(request);

        /**
         * set list bannerVM
         */


       /*set list newProductVM*/
       List<ProductVM> productNewVMs = new ArrayList<>();
       List<Product> newProduct = productService.getListNewProduct();
       for (Product product1 : newProduct) {
           ProductVM productVM = new ProductVM();
           productVM.setName(product1.getName());
           productVM.setMainImage(product1.getMainImage());
           productVM.setPrice(df.format(product1.getPrice()));
           productVM.setShortDesc(product1.getName());
           productVM.setId(product1.getId());
           productVM.setCreatedDate(product1.getCreatedDate());
           if (product1.getPrice()!=setPriceVM(product1)){
               productVM.setHasSale(true);
               productVM.setPriceSale(df.format(setPriceVM(product1)));
           }else {
               productVM.setHasSale(false);
           }
           productNewVMs.add(productVM);
       }

        /*Set list top selling products*/
        List<ProductVM> productTopSellingVMs = new ArrayList<>();
        List<Integer> productIds = productService.getTopSellingProductId();
        for (Integer productId : productIds) {
            ProductVM productVM = new ProductVM();
            Product product2 = productService.findOne(productId);
            productVM.setName(product2.getName());
            productVM.setMainImage(product2.getMainImage());
            productVM.setPrice(df.format(product2.getPrice()));
            productVM.setShortDesc(product2.getName());
            productVM.setId(product2.getId());
            productVM.setCreatedDate(product2.getCreatedDate());
            if (product2.getPrice()!=setPriceVM(product2)){
                productVM.setHasSale(true);
                productVM.setPriceSale(df.format(setPriceVM(product2)));
            }else {
                productVM.setHasSale(false);
            }
            productTopSellingVMs.add(productVM);
        }

        /*CartVM*/
        CartVM cartVM = setCartVM(guid);
        /*HTML*/


        /**
         * set vm
         */

        vm.setProductNewVMs(productNewVMs);
        vm.setProductTopSellingVMs(productTopSellingVMs);
        model.addAttribute("cartVM",cartVM);
        model.addAttribute("vm", vm);

        return "home";
    }

}
