package com.liftoff.controllers;

import com.liftoff.models.Link;
import com.liftoff.models.data.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("admin/manageLinks")
public class AdminLinkController {

    @Autowired
    private LinkRepository linkRepository;

    @GetMapping ("")
    public String displayManageLinksPage (Model model) {
        List<Link> listLinks = linkRepository.findAll();
        model.addAttribute("title", "Admin Portal: Manage Links");
        model.addAttribute("listLinks", listLinks);
        return "/admin/manageLinks/index";
    }

    @GetMapping ("new")
    public String displayAddNewLink (Model model) {
        List<Link> listLinks = linkRepository.findAll();
        model.addAttribute("title", "Admin Portal: add link");
        model.addAttribute("button", "SAVE NEW");
        model.addAttribute("listLinks", listLinks);
        model.addAttribute("link", new Link());
        return "/admin/manageLinks/new";
    }

    @GetMapping ("edit/{id}")
    public String displayEditLink (@PathVariable("id") Integer id, Model model) {
        List<Link> listLinks = linkRepository.findAll();
        Link link = linkRepository.findById(id).get();
        model.addAttribute("listLinks", listLinks);
        model.addAttribute("title", "Admin Portal: edit link");
        model.addAttribute("button", "SAVE CHANGES");
        model.addAttribute("link", link);
        return "/admin/manageLinks/new";

    }

    @PostMapping ("save")
    public String saveLink (Link link) {
        linkRepository.save(link);
        return "redirect:/admin/manageLinks";
    }

    @GetMapping ("delete/{id}")
    public String deleteLink (Link link) {
        linkRepository.delete(link);
        return "redirect:/admin/manageLinks";
    }


}
