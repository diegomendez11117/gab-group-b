package com.liftoff.controllers.site;


import com.liftoff.models.data.FaqRepository;
import com.liftoff.models.Faq;
import com.liftoff.models.data.WelcomeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping ("help")
public class HelpController {

    @Autowired
    private FaqRepository faqRepository;

    @Autowired
    private WelcomeRepository welcomeRepository;



    @GetMapping ("")
    public String displayHelpPage (Model model) {
        List<Faq> listFaq = faqRepository.findAll();
        model.addAttribute("title", "Help");
        model.addAttribute("listFaq",listFaq);

        return "/help/index";
    }

    @GetMapping ("faq/{id}")
    public String displayFaq (@PathVariable("id") Integer id, Model model) {
        if (faqRepository.existsById(id)) {
            Faq faq = faqRepository.findById(id).get();
            model.addAttribute("faq", faq);
            model.addAttribute("title", "FAQ");
            return "/help/faq";
        } else {
            return "/500";
        }
    }




}
