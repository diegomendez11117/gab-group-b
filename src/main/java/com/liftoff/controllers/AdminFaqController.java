package com.liftoff.controllers;

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
@RequestMapping("admin/manageFaqs")
public class AdminFaqController {

    @Autowired
    private FaqRepository faqRepository;

    @GetMapping ("")
    public String displayManageFAQPage (Model model) {
        List<Faq> listFaqs = faqRepository.findAll();
        model.addAttribute("title", "Admin Portal: Manage FAQs");
        model.addAttribute("listFaqs", listFaqs);
        return "/admin/manageFaqs/index";
    }

    @GetMapping ("new")
    public String displayAddNewFAQ (Model model,Faq faq) {
        List<Faq> listFaqs = faqRepository.findAll();
        model.addAttribute("title", "Admin Portal: add FAQ");
        model.addAttribute("button", "SAVE");
        model.addAttribute("listFaqs", listFaqs);
        model.addAttribute("faq", new Faq());
        return "/admin/manageFaqs/new";
    }

    @GetMapping ("edit/{id}")
    public String displayEditFAQ (@PathVariable("id") Integer id, Model model) {
        List<Faq> listFaqs = faqRepository.findAll();
        Faq faq = faqRepository.findById(id).get();
        model.addAttribute("listFaqs", listFaqs);
        model.addAttribute("title", "Admin Portal: edit FAQ");
        model.addAttribute("button", "Save Changes");
        model.addAttribute("faq", faq);
        return "/admin/manageFaqs/new";
    }

    @PostMapping ("save")
    public String saveFAQ (Faq faq, Model model) {
        faqRepository.save(faq);
        return "redirect:/admin/manageFaqs";
   }




}
