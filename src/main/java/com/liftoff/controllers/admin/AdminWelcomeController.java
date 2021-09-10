package com.liftoff.controllers.admin;

import com.liftoff.models.*;
import com.liftoff.models.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("account")
public class AdminWelcomeController {

    @Autowired
    private WelcomeRepository welcomeRepository;

     @GetMapping ("")
    public String displayAdminPortalLandingPage(Model model) {
        Welcome welcome = welcomeRepository.getById(1);
        model.addAttribute("title", "Admin Portal:");
        model.addAttribute("welcome", welcome);
        return "/account/index";
    }

    @GetMapping ("manageWelcome/edit")
    public String displayManageWelcome (Model model) {
        Welcome welcome = welcomeRepository.getById(1);
        model.addAttribute("title", "Admin Portal: Manage UI");
        model.addAttribute("welcome",welcome);
        return "/account/manageWelcome/edit";
    }



    @PostMapping("manageWelcome/save")
    public String updateWelcome(Welcome welcome) {
        welcomeRepository.save(welcome);
        return "/account/index";
    }



}