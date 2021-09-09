package com.liftoff.controllers.authentication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForgotPasswordController {

    @GetMapping("/forgotPassword")
    public String showForgotPasswordForm(Model model){
        model.addAttribute("title", "Forgot Password");
        return "forgotPassword";
    }


}
