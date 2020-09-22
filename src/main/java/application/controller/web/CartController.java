package application.controller.web;

import application.data.service.CartService;
import application.model.viewmodel.cart.CartVM;
import application.model.viewmodel.common.ProductVM;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping(path = "/cart")
public class CartController extends BaseController {

    private static final Logger logger = LogManager.getLogger(CartController.class);


    @Autowired
    private CartService cartService;

    @GetMapping("")
    public String cart(Model model,
                       @Valid @ModelAttribute("product") ProductVM product,
                       HttpServletResponse response,
                       HttpServletRequest request,
                       final Principal principal) {

        this.checkCookie(response,request,principal);
        String guid = getGuid(request);

        CartVM cartVM = setCartVM(guid);

        model.addAttribute("cartVM",cartVM);

        return "/cart";
    }

}
