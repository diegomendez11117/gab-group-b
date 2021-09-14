package com.liftoff.controllers.site;

import com.liftoff.models.Link;
import com.liftoff.models.data.LinkRepository;
import com.liftoff.models.data.UiRepository;
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
    private UiRepository uiRepository;

    @Autowired
    private LinkRepository linkRepository;



    @GetMapping ("")
    public String displayWelcome(Model model) {
        List<Link> listLinks = linkRepository.findAll();
        String homeParagraph1 = uiRepository.getById(1).getText();
        String homeParagraph2 = uiRepository.getById(2).getText();
        String homeParagraph3 = uiRepository.getById(3).getText();
        model.addAttribute("homeParagraph1", homeParagraph1);
        model.addAttribute("homeParagraph2", homeParagraph2);
        model.addAttribute("homeParagraph3", homeParagraph3);
        model.addAttribute("listLinks",listLinks);
        return "/index";
    }

    @GetMapping ("about")
    public String displayAboutUs(Model model) {
        String about1Title= uiRepository.getById(11).getText();
        String about2Title= uiRepository.getById(13).getText();
        String about3Title= uiRepository.getById(15).getText();
        String about1Description= uiRepository.getById(12).getText();
        String about2Description= uiRepository.getById(14).getText();
        String about3Description= uiRepository.getById(16).getText();
        model.addAttribute("about1Title", about1Title);
        model.addAttribute("about2Title", about2Title);
        model.addAttribute("about3Title", about3Title);
        model.addAttribute("about1Description", about1Description);
        model.addAttribute("about2Description", about2Description);
        model.addAttribute("about3Description", about3Description);
        return "/about";
    }


    @GetMapping ("403")
    public String error403() {
        return "/error/403";
    }

    @GetMapping ("500")
    public String error500() {
        return "/error/500";
    }

    @GetMapping ("reset")
    public String errorReset() {
        return "/error/reset";
    }
}
