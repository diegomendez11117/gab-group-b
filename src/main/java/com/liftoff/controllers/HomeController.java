package com.liftoff.controllers;

import com.liftoff.models.Link;
import com.liftoff.models.Welcome;
import com.liftoff.models.data.LinkRepository;
import com.liftoff.models.data.WelcomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping ("")
public class HomeController {

    @Autowired
    private WelcomeRepository welcomeRepository;

    @Autowired
    private LinkRepository linkRepository;

    @GetMapping ("")
    public String displayWelcome(Model model) {
        List<Link> listLinks = linkRepository.findAll();
        Welcome welcome = welcomeRepository.getById(1);
        model.addAttribute("welcome", welcome);
        model.addAttribute("title", "Welcome!");
        model.addAttribute("listLinks",listLinks);
        return "/index";
    }

    @GetMapping ("about")
    public String displayAboutUs(Model model) {
        Welcome welcome = welcomeRepository.getById(1);
        model.addAttribute("welcome", welcome);
        model.addAttribute("title", "About Us!");

        return "/about";
    }
}
