package com.liftoff.controllers;

import com.liftoff.models.Faq;
import com.liftoff.models.WantTo;
import com.liftoff.models.Welcome;
import com.liftoff.models.data.WantToRepository;
import com.liftoff.models.data.WelcomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("account/manageWantTos")
public class AdminWantToController {

    @Autowired
    private WelcomeRepository welcomeRepository;

    @Autowired
    private WantToRepository wantToRepository;

    @GetMapping ("")
    public String displayManageWantTosPage (Model model) {
        List<WantTo> listWantTo = wantToRepository.findAll();
        Welcome welcome = welcomeRepository.getById(1);
        model.addAttribute("title", "Admin Portal: Manage Want-To");
        model.addAttribute("listWantTo", listWantTo);
        model.addAttribute("welcome", welcome);
        return "/account/ManageWantTos/index";
    }

    @GetMapping ("/new")
    public String displayAddNewWantTo (Model model) {
        List<WantTo> listWantTo = wantToRepository.findAll();
        model.addAttribute("title", "Admin Portal: add wantTo");
        model.addAttribute("button", "SAVE");
        model.addAttribute("listWantTo", listWantTo);
        model.addAttribute("wantTo", new WantTo());
        return "/account/manageWantTos/edit";
    }

    @GetMapping ("/edit/{id}")
    public String displayEditWantTo(@PathVariable("id") Integer id, Model model) {
        if (wantToRepository.existsById(id)) {
            List<WantTo> listWantTo = wantToRepository.findAll();
            WantTo wantTo = wantToRepository.findById(id).get();
            model.addAttribute("title", "Admin Portal: add wantTo");
            model.addAttribute("button", "SAVE");
            model.addAttribute("listWantTo", listWantTo);
            model.addAttribute("wantTo", wantTo);
            return "/account/manageWantTos/edit";
        } else {
            return "/500";
        }
    }

    @PostMapping ("/save")
    public String saveWantTo (WantTo wantTo) {
        wantToRepository.save(wantTo);
        return "redirect:/account/manageWantTos";
    }
}
