package com.liftoff.controllers;

import com.liftoff.data.WantToRepository;
import com.liftoff.models.WantTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping ("wantTo")
public class WantToController {

    @Autowired
    private WantToRepository wantToRepository;

    @GetMapping ("")
    public String displayAllWantTo (Model model) {
        List<WantTo> listWantTo = wantToRepository.findAll();
        model.addAttribute("title", "I want to do this shit");
        model.addAttribute("listWantTo", listWantTo);

        return "wantTo/index";
    }
}
