package com.liftoff.controllers.admin;

import com.liftoff.models.*;
import com.liftoff.models.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("account/manageUI")
public class AdminUIController {

    @Autowired
    private UIRepository UIRepository;

    @GetMapping ("edit")
    public String displayUISettings(Model model) {
        Welcome welcome = UIRepository.getById(1);
        model.addAttribute("title", "Admin Portal: Manage UI");
        model.addAttribute("welcome",welcome);
        return "/account/manageUI/edit";
    }

    @PostMapping("save")
    public String updateUISettings(Welcome welcome) {
        UIRepository.save(welcome);
        return "/account/manageUI/index";
    }



}
