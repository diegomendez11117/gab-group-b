package com.liftoff.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {

    @GetMapping ("")
    public String displayAdminPage (Model model) {
        model.addAttribute("title", "Admin Portal");
        return "admin/index";
    }

    @GetMapping ("users")
    public String displayManageUsersPage (Model model) {
        model.addAttribute("title", "Manage Users");
        return "/admin/users";
    }

    @GetMapping ("welcome")
    public String displayManageWelcomePage (Model model) {
        model.addAttribute("title", "Manage Welcome Page");
        return "/admin/welcome";
    }

    @GetMapping ("faqs")
    public String displayManageFAQPage (Model model) {
        model.addAttribute("title", "Admin Manage FAQs");
        return "/admin/faqs";
    }

    @GetMapping ("wantTos")
    public String displayManageWantTosPage (Model model) {
        model.addAttribute("title", "Manage Want To");
        return "/admin/wantTos";
    }

    @GetMapping ("links")
    public String displayManageLinksPage (Model model) {
        model.addAttribute("title", "Manage Links");
        return "/admin/links";
    }

}
