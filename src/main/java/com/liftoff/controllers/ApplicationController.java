package com.liftoff.controllers;

import com.liftoff.models.Link;
import com.liftoff.models.Role;
import com.liftoff.models.User;
import com.liftoff.models.Welcome;
import com.liftoff.models.data.LinkRepository;
import com.liftoff.models.data.RoleRepository;
import com.liftoff.models.data.UserRepository;
import com.liftoff.models.data.WelcomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping ("")
public class ApplicationController {

    @Autowired
    private WelcomeRepository welcomeRepository;

    @Autowired
    private LinkRepository linkRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @GetMapping ("")
    public String displayWelcome(Model model) {
        List<Link> listLinks = linkRepository.findAll();
        Welcome welcome = welcomeRepository.getById(1);
        model.addAttribute("welcome", welcome);
        model.addAttribute("title", "Welcome!");
        model.addAttribute("listLinks",listLinks);
        return "/index";
    }

    @GetMapping ("about")
    public String displayAboutUs(Model model) {
        Welcome welcome = welcomeRepository.getById(1);
        model.addAttribute("welcome", welcome);
        model.addAttribute("title", "About Us!");

        return "/about";
    }





//    @GetMapping("login")
//    public String displayLogin (Model model){
//        return "/login";
//    }
//
//
//
//
//
//    @GetMapping ("register")
//    public String displayCreateNewUser (Model model) {
//        List<Role> listRoles = roleRepository.findAll();
//
//        model.addAttribute("title","Add User");
//        model.addAttribute("user",new User());
//        model.addAttribute("listRoles", listRoles);
//        model.addAttribute("password", "password");
//        model.addAttribute("verifyPassword", "verifyPassword");
//
//        return "/register";
//    }
//
//    @PostMapping("save")
//    public String saveUser(Model model, User user){
//        String password = user.getPassword();
//        String hash = encoder.encode(password);
//        user.setPassword(hash);
//
//        System.out.println(password);
//        System.out.println(hash);
//
//        userRepository.save(user);
//        return "redirect:";
//    }




}
