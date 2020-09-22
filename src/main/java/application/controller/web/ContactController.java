////package application.controller.web;
////
////
////import application.constant.MyConstant;
////import application.data.model.Product;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.mail.SimpleMailMessage;
////import org.springframework.mail.javamail.JavaMailSender;
////import org.springframework.stereotype.Controller;
////import org.springframework.ui.Model;
////import org.springframework.web.bind.annotation.*;
////
////import javax.servlet.http.HttpServletRequest;
////import javax.servlet.http.HttpServletResponse;
////import javax.validation.Valid;
////import java.security.Principal;
////
////@Controller
////@RequestMapping("/contact-us")
////public class ContactUsController extends BaseController {
////
////    @Autowired
////    public JavaMailSender emailSender;
////
////    @GetMapping(value = "")
////    public String news(Model model,
////                       HttpServletResponse response,
////                       HttpServletRequest request,
////                       final Principal principal,
////                       @Valid @ModelAttribute("productname") Product productName){
////        totalCart(model,response,request,principal);
////
////        return "contactus";
////
////    }
////
////
////
////    @PostMapping("/send")
////    public String sendSimpleEmail(
////            Model model,
////            HttpServletResponse response,
////            HttpServletRequest request,
////            final Principal principal,
////            @RequestParam String name,@RequestParam String email,@RequestParam String content) {
////
//////        // Create a Simple MailMessage.
////        SimpleMailMessage message = new SimpleMailMessage();
////
////        message.setTo(MyConstant.MY_EMAIL);
////        message.setSubject("Dịch vụ, sản phẩm");
////        message.setText("Hello: "+ name +" \n"+
////                "Mail: " + email +" \n"
////                + content);
////        // Send Message!
////
////
////
////        SimpleMailMessage message1 = new SimpleMailMessage();
////
////        message1.setTo(email);
////        message1.setSubject("Flavours");
////        message1.setText("Thank You: "+ name +" \n"+
////                    "Your comments have been recorded");
////
////        try {
////            // Send Message!
////            this.emailSender.send(message);
////            this.emailSender.send(message1);
////
////            totalCart(model,response,request,principal);
////            return "redirect:/contact-us?success";
////
////        } catch (Exception e) {
////            return "redirect:/contact-us?fail";
////        }
////
////
////    }
////}
//
//package application.controller.web;
//
//import application.data.service.ContactSerive;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//
//import javax.validation.Valid;
//
//@Controller
//public class ContactController {
//
//    @Autowired
//    private ContactSerive contactSerive;
//
//    @GetMapping("/contact")
//
//  public  String home(Model model,
//                      @Valid @ModelAttribute
//
//                      )
//
//
//
//
//
//
//
//
//
//
//
//
//
//}