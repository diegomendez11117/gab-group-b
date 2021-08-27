package com.liftoff.controllers;

import com.liftoff.models.Welcome;
import com.liftoff.models.data.WantToRepository;
import com.liftoff.models.WantTo;
import com.liftoff.models.data.WelcomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping ("wantTo")
public class WantToController {

    @Autowired
    private WantToRepository wantToRepository;

    @Autowired
    private WelcomeRepository welcomeRepository;

    @GetMapping ("")
    public String displayAllWantTo (Model model) {
        Welcome welcome = welcomeRepository.findById(1).get();
        List<WantTo> listWantTo = wantToRepository.findAll();
        model.addAttribute("title", "What to do Next...");
        model.addAttribute("listWantTo", listWantTo);
        model.addAttribute("welcome", welcome);

        return "wantTo/index";
    }

    @GetMapping ("wantTo/{id}")
    public String displayWantTo(@PathVariable("id") Integer id, Model model) {
        WantTo wantTo = wantToRepository.findById(id).get();
        model.addAttribute("wantTo",wantTo);
        model.addAttribute("title", "I Want To ...");
        return "/wantTo/wantTo";
    }

}
