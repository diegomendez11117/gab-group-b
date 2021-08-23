package com.liftoff.controllers;

import com.liftoff.models.*;
import com.liftoff.models.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private WelcomeRepository welcomeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FaqRepository faqRepository;

    @Autowired
    private WantToRepository wantToRepository;

    @Autowired
    private LinkRepository linkRepository;


    @GetMapping ("")
    public String displayManageWelcomePage (Model model) {
        Welcome welcome = welcomeRepository.getById(1);
        model.addAttribute("title", "Manage Welcome Page");
        model.addAttribute("welcome",welcome);
        return "/admin/index";
    }

    @PostMapping("updateWelcome")
    public String updateWelcome(Welcome welcome, Model model) {
        welcomeRepository.save(welcome);
        return "redirect:";
    }


    @GetMapping ("manageUsers")
    public String displayManageUsersPage (Model model) {
        List<User> listUser = userRepository.findAll();
        model.addAttribute("title", "Manage Users");
        model.addAttribute("listUser", listUser);
        model.addAttribute("user", new User());
        return "/admin/manageUsers/index";
    }


    @GetMapping ("manageFaqs")
    public String displayManageFAQPage (Model model) {
        List<Faq> listFaqs = faqRepository.findAll();
        model.addAttribute("title", "Admin Manage FAQs");
        model.addAttribute("listFaqs", listFaqs);
        //model.addAttribute("faq", new Faq());
        return "/admin/manageFaqs/index";
    }

    @GetMapping ("manageFaqs/new")
    public String displayAddNewFAQ (Model model) {
        List<Faq> listFaqs = faqRepository.findAll();
        model.addAttribute("title", "Admin Manage FAQs");
        model.addAttribute("listFaqs", listFaqs);
        model.addAttribute("faq", new Faq());
        return "/admin/manageFaqs/new";
    }

    @PostMapping ("manageFaqs/save")
    public String saveFAQ (Faq faq, Model model) {
        faqRepository.save(faq);
        return "redirect:";
    }




    @GetMapping ("manageWantTos")
    public String displayManageWantTosPage (Model model) {
        List<WantTo> listWantTo = wantToRepository.findAll();
        model.addAttribute("title", "Manage Want To");
        model.addAttribute("listWantTo", listWantTo);
        model.addAttribute("wantTo", new WantTo());
        return "/admin/ManageWantTos/index";
    }


    @GetMapping ("manageLinks")
    public String displayManageLinksPage (Model model) {
        List<Link> listLink = linkRepository.findAll();
        model.addAttribute("title", "Manage Links");
        model.addAttribute("listLink", listLink);
        model.addAttribute("link", new Link());
        return "/admin/manageLinks/index";
    }

}
