package com.liftoff.controllers;

import com.liftoff.models.*;
import com.liftoff.models.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private WelcomeRepository welcomeRepository;

     @GetMapping ("")
    public String displayAdminPortalLandingPage(Model model) {
        Welcome welcome = welcomeRepository.getById(1);
        model.addAttribute("title", "Admin Portal:");
        model.addAttribute("welcome",welcome);
        return "/admin/index";
    }

    @GetMapping ("manageWelcome/editWelcome")
    public String displayManageWelcome (Model model) {
        Welcome welcome = welcomeRepository.getById(1);
        model.addAttribute("title", "Admin Portal: Manage Welcome Page");
        model.addAttribute("welcome",welcome);
        return "/admin/manageWelcome/editWelcome";
    }

    @GetMapping ("manageWelcome/editAbout")
    public String displayManageAboutUs (Model model) {
        Welcome welcome = welcomeRepository.getById(1);
        model.addAttribute("title", "Admin Portal: Manage About Us");
        model.addAttribute("welcome",welcome);
        return "/admin/manageWelcome/editAbout";
    }

    @GetMapping ("manageWelcome/editPortal")
    public String displayManagePortal (Model model) {
        Welcome welcome = welcomeRepository.getById(1);
        model.addAttribute("title", "Admin Portal: Manage Portal Welcome");
        model.addAttribute("welcome",welcome);
        return "/admin/manageWelcome/editPortal";
    }

    @PostMapping("manageWelcome/save")
    public String updateWelcome(Welcome welcome) {
        welcomeRepository.save(welcome);
        return "redirect:";
    }



}
