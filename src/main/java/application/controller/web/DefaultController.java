package application.controller.web;

import application.constant.StatusRegisterUserEnum;
import application.data.model.User;
import application.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class DefaultController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }

    @GetMapping(path="/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "/register";
    }


    @RequestMapping(path = "/register-user", method = RequestMethod.POST)
    public String registerNewUser(@Valid @ModelAttribute("user") User user) {
        StatusRegisterUserEnum statusRegisterUserEnum = userService.registerNewUser(user);
        if (statusRegisterUserEnum.equals(StatusRegisterUserEnum.Error_OnSystem)) {
            return "redirect:/register?error_system";
        }
        else if (statusRegisterUserEnum.equals(StatusRegisterUserEnum.Existed_Username)){
            return "redirect:/register?existed_username";
        }
        else if(statusRegisterUserEnum.equals(StatusRegisterUserEnum.Existed_Email)){
            return "redirect:/register?existed_email";
        }
        else if(statusRegisterUserEnum.equals(StatusRegisterUserEnum.Success)){
            return "redirect:/login?success";
        }
        return "redirect:/login";
    }
}