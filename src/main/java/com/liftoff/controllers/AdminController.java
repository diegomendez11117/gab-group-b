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


    @GetMapping ("manageUsers")
    public String displayManageUsersPage (Model model) {
        List<User> listUser = userRepository.findAll();
        model.addAttribute("title", "Admin Portal: Manage Users");
        model.addAttribute("listUser", listUser);
        model.addAttribute("user", new User());
        return "/admin/manageUsers/index";
    }

    @GetMapping("manageUsers/new")
    public String displayRegisterNewUser(){
        return "/register";
    }


    @GetMapping ("manageUsers/save")
    public String saveUser (User user) {
        userRepository.save(user);
        return "redirect:";
    }



    @GetMapping ("manageFaqs")
    public String displayManageFAQPage (Model model) {
        List<Faq> listFaqs = faqRepository.findAll();
        model.addAttribute("title", "Admin Portal: Manage FAQs");
        model.addAttribute("listFaqs", listFaqs);
        //model.addAttribute("faq", new Faq());
        return "/admin/manageFaqs/index";
    }

    @GetMapping ("manageFaqs/new")
    public String displayAddNewFAQ (Model model) {
        List<Faq> listFaqs = faqRepository.findAll();
        model.addAttribute("title", "Admin Portal: add FAQ");
        model.addAttribute("listFaqs", listFaqs);
        model.addAttribute("faq", new Faq());
        return "/admin/manageFaqs/new";
    }

    @PostMapping ("manageFaqs/save")
    public String saveFAQ (Faq faq) {
        faqRepository.save(faq);
        return "redirect:";
    }



    @GetMapping ("manageLinks")
    public String displayManageLinksPage (Model model) {
        List<Link> listLink = linkRepository.findAll();
        model.addAttribute("title", "Admin Portal: Manage Links");
        model.addAttribute("listLink", listLink);
        //model.addAttribute("link", new Link());
        return "/admin/manageLinks/index";
    }

    @GetMapping ("manageLinks/new")
    public String displayAddNewLink (Model model) {
        List<Link> listLink = linkRepository.findAll();
        model.addAttribute("title", "Admin Portal: add link");
        model.addAttribute("listLink", listLink);
        model.addAttribute("link", new Link());
        return "/admin/manageLinks/new";
    }

    @PostMapping ("manageLinks/save")
    public String saveLink (Link link) {
        linkRepository.save(link);
        return "redirect:";
    }




    @GetMapping ("manageWantTos")
    public String displayManageWantTosPage (Model model) {
        List<WantTo> listWantTo = wantToRepository.findAll();
        model.addAttribute("title", "Admin Portal: Manage Want-To");
        model.addAttribute("listWantTo", listWantTo);
        model.addAttribute("wantTo", new WantTo());
        return "/admin/ManageWantTos/index";
    }

    @GetMapping ("manageWantTos/new")
    public String displayAddNewWantTo (Model model) {
        List<WantTo> listWantTo = wantToRepository.findAll();
        model.addAttribute("title", "Admin Portal: add wantTo");
        model.addAttribute("listWantTo", listWantTo);
        model.addAttribute("wantTo", new WantTo());
        return "/admin/manageWantTos/new";
    }

    @PostMapping ("manageWantTos/save")
    public String saveWantTo (WantTo wantTo) {
        wantToRepository.save(wantTo);
        return "redirect:";
    }
}
