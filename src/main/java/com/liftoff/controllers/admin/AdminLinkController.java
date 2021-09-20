package com.liftoff.controllers.admin;

import com.liftoff.models.Faq;
import com.liftoff.models.Link;
import com.liftoff.models.WantTo;
import com.liftoff.models.data.FaqRepository;
import com.liftoff.models.data.LinkRepository;
import com.liftoff.models.data.WantToRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("account/manageLinks")
public class AdminLinkController {

    @Autowired
    private LinkRepository linkRepository;

    @Autowired
    private WantToRepository wantToRepository;

    @Autowired
    private FaqRepository faqRepository;


    @GetMapping ("")
    public String displayManageLinksPage (Model model) {
        List<Link> listLinks = linkRepository.findAll();
        model.addAttribute("pageTitle", "Link Management");
        model.addAttribute("listLinks", listLinks);
        return "/account/manageLinks/index";
    }

    @GetMapping ("new")
    public String displayAddNewLink (Model model) {
        List<Faq> listFaqs = faqRepository.findAll();
        List<WantTo> listWantTos = wantToRepository.findAll();
        List<Link> listLinks = linkRepository.findAll();
        model.addAttribute("listLinks", listLinks);
        model.addAttribute("listFaqs", listFaqs);
        model.addAttribute("listWantTos",listWantTos);
        model.addAttribute("pageTitle", "Link Management");
        model.addAttribute("title", "Adding new Link");
        model.addAttribute("button", "Save");
        model.addAttribute("hide","hide");
        model.addAttribute("link", new Link());
       return "/account/manageLinks/edit";
    }

    @GetMapping ("newWantToLink/{id}")
    public String displayAddNewWantToLink (@PathVariable("id") Integer id, Model model) {
        if (wantToRepository.existsById(id)) {
            List<WantTo> listWantTos = wantToRepository.findAll();
            List<Link> listLinks = linkRepository.findAll();
            WantTo wantTo = wantToRepository.findById(id).get();
            model.addAttribute("listLinks", listLinks);
            model.addAttribute("listWantTos", listWantTos);
            model.addAttribute("pageTitle", "Link Management");
            model.addAttribute("title", "Editing Link");
            model.addAttribute("button", "Update");
            model.addAttribute("hide", "hide");
            Link newLink = new Link();
            newLink.setWantTo(wantTo);
            model.addAttribute("link", newLink);
            return "/account/manageLinks/edit";
        } else {
            return "500";
        }
    }

    @GetMapping ("newFaqLink/{id}")
    public String displayAddNewFaqLink (@PathVariable("id") Integer id, Model model) {
        if (faqRepository.existsById(id)) {
            List<Faq> listFaqs = faqRepository.findAll();
            List<Link> listLinks = linkRepository.findAll();
            Faq faq = faqRepository.findById(id).get();
            model.addAttribute("listLinks", listLinks);
            model.addAttribute("listFaqs", listFaqs);
            model.addAttribute("title", "Adding new Link");
            model.addAttribute("button", "Save");
            model.addAttribute("hide", "hide");
            Link newLink = new Link();
            newLink.setFaq(faq);
            model.addAttribute("link", newLink);
            return "/account/manageLinks/edit";
        } else {
            return "/500";
        }
    }


    @GetMapping ("edit/{id}")
    public String displayEditLink (@PathVariable("id") Integer id, Model model) {
        if (linkRepository.existsById(id)) {
            List<Faq> listFaqs = faqRepository.findAll();
            List<WantTo> listWantTos = wantToRepository.findAll();
            List<Link> listLinks = linkRepository.findAll();
            Link link = linkRepository.findById(id).get();
            model.addAttribute("listLinks", listLinks);
            model.addAttribute("listFaqs", listFaqs);
            model.addAttribute("listWantTos", listWantTos);
            model.addAttribute("pageTitle", "Link Management");
            model.addAttribute("title", "Editing Link");
            model.addAttribute("button", "Update");
            model.addAttribute("link", link);
            return "/account/manageLinks/edit";
        } else {
            return "/500";
        }
    }

    @GetMapping ("delete/{id}")
    public String deleteLink (Link link,Model model) {
        linkRepository.delete(link);
        List<Link> listLinks = linkRepository.findAll();
        model.addAttribute("title", "Deleting Link");
        model.addAttribute("pageTitle", "Link Management");
        model.addAttribute("listLinks", listLinks);
        return "/account/manageLinks/index";
    }

    @PostMapping ("save")
    public String saveLink (Link link) {
        linkRepository.save(link);
        return "redirect:/account/manageLinks";
    }

}
