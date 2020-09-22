package application.controller.web;

import application.data.model.*;
import application.data.service.*;
import application.model.viewmodel.cart.CartVM;
import application.model.viewmodel.common.ProductVM;
import application.model.viewmodel.order.OrderDetailVM;
import application.model.viewmodel.order.OrderHistoryVM;
import application.model.viewmodel.order.OrderProductVM;
import application.model.viewmodel.order.OrderVM;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.security.Principal;
import java.text.DecimalFormat;
import java.util.*;

@Controller
@RequestMapping(path = "/order")
public class OrderController extends BaseController {

    private static final Logger logger = LogManager.getLogger(OrderController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private CartService cartService;

    @Autowired
    private CartProductService cartProductService;

    @Autowired
    private ProductService productService;

    @GetMapping("/checkout")
    public String checkout(Model model,
                           @Valid @ModelAttribute("product") ProductVM productName,
                           HttpServletResponse response,
                           HttpServletRequest request,
                           final Principal principal) {
        OrderVM order = new OrderVM();
        String guid = getGuid(request);
        if(principal!= null) {
            String  username = SecurityContextHolder.getContext().getAuthentication().getName();
            User userEntity = userService.findUserByUsername(username);
            if(userEntity!= null) {
                order.setAddress(userEntity.getAddress());
                order.setCustomerName(userEntity.getName());
                order.setPhoneNumber(userEntity.getPhoneNumber());
                order.setEmail(userEntity.getEmail());
            }
        }

        CartVM cartVM = setCartVM(guid);

        model.addAttribute("order",order);
        model.addAttribute("cartVM",cartVM);
        return "/checkout";
    }

    @PostMapping("/checkout")
    public String checkout (Model model,
                            @Valid @ModelAttribute("order") OrderVM orderVM,
                            @Valid @ModelAttribute("product") ProductVM productName,
                            HttpServletResponse response,
                            HttpServletRequest request,
                            final Principal principal) throws Exception {
        DecimalFormat df = new DecimalFormat("##,###,###");
        Order order = new Order();

        boolean flag = false;

        Cookie cookie[] = request.getCookies();

        String guid = null;

        if(cookie!=null) {
            for(Cookie c : cookie) {
                if(c.getName().equals("guid")) {
                    flag = true;
                    guid = c.getValue();
                }
            }
        }

        try {
            if(flag == true) {

                double totalPrice = 0;

                if(principal != null) {
                    String  username = SecurityContextHolder.getContext().getAuthentication().getName();
                    order.setUserName(username);
                }

                order.setGuid(guid);
                order.setAddress(orderVM.getAddress());
                order.setEmail(orderVM.getEmail());
                order.setPhoneNumber(orderVM.getPhoneNumber());
                order.setCustomerName(orderVM.getCustomerName());
                order.setCreatedDate(new Date());
                order.setStatus("Đang giao hàng");

                Cart cartEntity = cartService.findFirstCartByGuid(guid);
                if(cartEntity != null) {
                    Set<OrderProduct> orderProducts = new HashSet<>();
                    for (CartProduct cartProduct : cartEntity.getCartProducts()) {
                        OrderProduct orderProduct = new OrderProduct();
                        orderProduct.setOrder(order);
                        orderProduct.setProduct(cartProduct.getProduct());
                        orderProduct.setAmount(cartProduct.getAmount());
                        /*update amount product after order*/

                        double price;
                        if (cartProduct.getProduct().getPrice()!=setPriceVM(cartProduct.getProduct())){
                            price = cartProduct.getAmount()*setPriceVM(cartProduct.getProduct());
                        }else {
                            price = cartProduct.getAmount()*cartProduct.getProduct().getPrice();
                        }

                        totalPrice += price;

                        orderProduct.setPrice(price);

                        orderProducts.add(orderProduct);
                    }

                    order.setOrderProducts(orderProducts);
                    order.setPrice(totalPrice);

                    orderService.addNewOrder(order);

                    cartService.deleteCart(cartEntity.getId());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*CartVM*/

        CartVM cartVM = setCartVM(guid);


        model.addAttribute("cartVM",cartVM);


        return "redirect:/order/history";
    }

    @GetMapping("/history")
    public String orderHistory(Model model,
                               @Valid @ModelAttribute("product") ProductVM productName,
                               HttpServletResponse response,
                               HttpServletRequest request,
                               final Principal principal) {

        OrderHistoryVM vm = new OrderHistoryVM();

        DecimalFormat df = new DecimalFormat("##,###,###");



        List<OrderVM> orderVMS = new ArrayList<>();

        Cookie[] cookie = request.getCookies();

        String guid = null;
        boolean flag = false;

        List<Order> orderEntityList = null;

        if(principal != null) {
            String  username = SecurityContextHolder.getContext().getAuthentication().getName();
            orderEntityList = orderService.findOrderByGuidOrUserName(null,username);
        } else {
            if(cookie != null) {
                for(Cookie c : cookie) {
                    if(c.getName().equals("guid")) {
                        flag = true;
                        guid = c.getValue();
                    }
                }
                if(flag == true) {
                    orderEntityList = orderService.findOrderByGuidOrUserName(guid,null);
                }
            }
        }

        if(orderEntityList != null) {
            for(Order order : orderEntityList) {
                OrderVM orderVM = new OrderVM();
                orderVM.setId(order.getId());
                orderVM.setCustomerName(order.getCustomerName());
                orderVM.setEmail(order.getEmail());
                orderVM.setAddress(order.getAddress());
                orderVM.setPhoneNumber(order.getPhoneNumber());
                orderVM.setPrice(df.format(order.getPrice()));
                orderVM.setCreatedDate(order.getCreatedDate());
                orderVM.setStatus(order.getStatus());

                orderVMS.add(orderVM);
            }
        }

        CartVM cartVM = setCartVM(guid);


        vm.setOrderVMS(orderVMS);

        model.addAttribute("cartVM",cartVM);
        model.addAttribute("vm",vm);

        return "/order-history";
    }


    @GetMapping("/history/{orderId}")
    public String getOrderDetail(Model model,
                                 @Valid @ModelAttribute("product") ProductVM productName,
                                 @PathVariable("orderId") int orderId,
                                 HttpServletResponse response,
                                 HttpServletRequest request,
                                 final Principal principal) {

        OrderDetailVM vm = new OrderDetailVM();
        String guid = getGuid(request);
        DecimalFormat df = new DecimalFormat("##,###,###");

        double totalPrice = 0;
        int totalProduct = 0;

        List<OrderProductVM> orderProductVMS = new ArrayList<>();

        Order orderEntity = orderService.findOne(orderId);

        if(orderEntity != null) {
            for(OrderProduct orderProduct : orderEntity.getOrderProducts()) {
                OrderProductVM orderProductVM = new OrderProductVM();

                orderProductVM.setProductId(orderProduct.getProduct().getId());
                orderProductVM.setMainImage(orderProduct.getProduct().getMainImage());
                orderProductVM.setAmount(orderProduct.getAmount());
                orderProductVM.setName(orderProduct.getProduct().getName());

                orderProductVM.setPrice(df.format(orderProduct.getPrice()));

                totalPrice += orderProduct.getPrice();
                totalProduct += orderProduct.getAmount();
                orderProductVMS.add(orderProductVM);
            }
        }

        CartVM cartVM = setCartVM(guid);


        vm.setOrderProductVMS(orderProductVMS);
        vm.setTotalPrice(df.format(totalPrice));
        vm.setTotalProduct(totalProduct);

        model.addAttribute("cartVM",cartVM);
        model.addAttribute("vm",vm);

        return "/order-detail";
    }



}

