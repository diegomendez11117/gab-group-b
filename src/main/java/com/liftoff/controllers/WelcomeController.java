package com.liftoff.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class WelcomeController {

    @GetMapping ("")
    public String displayWelcome(Model model) {
        return "welcome/index";
    }

    @GetMapping ("about")
    public String displayAboutUs(Model model) {
        return "welcome/about";
    }

    @GetMapping ("help")
    public String displayHelp(Model model) {
        return "welcome/help";
    }

}
