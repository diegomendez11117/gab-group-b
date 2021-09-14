package com.liftoff.controllers.site;

import com.liftoff.models.Ui;
import com.liftoff.models.data.WantToRepository;
import com.liftoff.models.WantTo;
import com.liftoff.models.data.UiRepository;
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
    private UiRepository uiRepository;

    @GetMapping ("")
    public String displayAllWantTo (Model model) {
        List<WantTo> listWantTo = wantToRepository.findAll();
        model.addAttribute("title", "What to do Next...");
        model.addAttribute("listWantTo", listWantTo);

        String lowPriorityTitle = uiRepository.getById(25).getText();
        String medPriorityTitle = uiRepository.getById(23).getText();;
        String highPriorityTitle = uiRepository.getById(21).getText();;
        String lowPriorityDescription = uiRepository.getById(26).getText();
        String medPriorityDescription= uiRepository.getById(24).getText();
        String highPriorityDescription= uiRepository.getById(22).getText();
        model.addAttribute("lowPriorityTitle", lowPriorityTitle);
        model.addAttribute("medPriorityTitle", medPriorityTitle);
        model.addAttribute("highPriorityTitle", highPriorityTitle);
        model.addAttribute("lowPriorityDescription", lowPriorityDescription);
        model.addAttribute("medPriorityDescription", medPriorityDescription);
        model.addAttribute("highPriorityDescription", highPriorityDescription);

        return "wantTo/index";
    }

    @GetMapping ("wantTo/{id}")
    public String displayWantTo(@PathVariable("id") Integer id, Model model) {
        if (wantToRepository.existsById(id)) {
            WantTo wantTo = wantToRepository.findById(id).get();
            model.addAttribute("wantTo", wantTo);
            model.addAttribute("title", "I Want To ...");
            return "/wantTo/wantTo";
        } else {
            return "/500";
        }
    }

}
