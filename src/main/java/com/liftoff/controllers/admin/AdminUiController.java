package com.liftoff.controllers.admin;

import com.liftoff.models.*;
import com.liftoff.models.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("account/manageUi")
public class AdminUiController {

    @Autowired
    private UiRepository uiRepository;

    @GetMapping ("")
    public String displayUiSettings(Model model){
        List<Ui> uiList = uiRepository.findAll();
        model.addAttribute("uiList", uiList);
        return "/account/manageUi/index";
    }

    @GetMapping ("edit/{id}")
    public String displayUISettings(@PathVariable("id") Integer id, Model model) {
        List<Ui> uiList = uiRepository.findAll();
        model.addAttribute("uiList", uiList);
        Ui uiToEdit = uiRepository.getById(id);
        model.addAttribute("uiToEdit", uiToEdit);
        return "/account/manageUi/edit";
    }

    @PostMapping("/save")
    public String saveUI(Ui ui) {
        uiRepository.save(ui);
        return "redirect:/account/manageUi/";
    }



}
