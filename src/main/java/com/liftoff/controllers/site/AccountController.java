package com.liftoff.controllers.site;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("account")
public class AccountController {



    @GetMapping ("")
    public String displayAdminPortalLandingPage(Model model) {
        model.addAttribute("title", "Admin Portal:");
        return "/account/index";
    }


}
