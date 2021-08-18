package com.liftoff.controllers;

import com.liftoff.models.*;
import com.liftoff.models.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {

    @GetMapping ("")
    public String displayAdminPage (Model model) {
        model.addAttribute("title", "Admin Portal");
        return "admin/index";
    }


    @Autowired
    private WelcomeRepository welcomeRepository;

    @GetMapping ("welcome")
    public String displayManageWelcomePage (Model model) {
        List<Welcome> listWelcome = welcomeRepository.findAll();
        Welcome welcome = welcomeRepository.getById(1);
        model.addAttribute("title", "Manage Welcome Page");
        model.addAttribute("welcome",welcome);
        return "/admin/welcome";
    }

    @Autowired
    private UserRepository userRepository;

    @GetMapping ("users")
    public String displayManageUsersPage (Model model) {
        List<User> listUser = userRepository.findAll();
        model.addAttribute("title", "Manage Users");
        model.addAttribute("listUser", listUser);
        model.addAttribute("user", new User());
        return "/admin/users";
    }


    @Autowired
    private FaqRepository faqRepository;

    @GetMapping ("faqs")
    public String displayManageFAQPage (Model model) {
        List<Faq> listFaqs = faqRepository.findAll();
        model.addAttribute("title", "Admin Manage FAQs");
        model.addAttribute("listFaqs", listFaqs);
        model.addAttribute("faq", new Faq());
        return "/admin/faqs";
    }

    @Autowired
    private WantToRepository wantToRepository;

    @GetMapping ("wantTos")
    public String displayManageWantTosPage (Model model) {
        List<WantTo> listWantTo = wantToRepository.findAll();
        model.addAttribute("title", "Manage Want To");
        model.addAttribute("listWantTo", listWantTo);
        model.addAttribute("wantTo", new WantTo());
        return "/admin/wantTos";
    }

    @Autowired
    private LinkRepository linkRepository;

    @GetMapping ("links")
    public String displayManageLinksPage (Model model) {
        List<Link> listLink = linkRepository.findAll();
        model.addAttribute("title", "Manage Links");
        model.addAttribute("listLink", listLink);
        model.addAttribute("link", new Link());
        return "/admin/links";
    }

}
