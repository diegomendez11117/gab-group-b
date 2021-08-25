package com.liftoff.controllers;

import com.liftoff.models.User;
import com.liftoff.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("admin/manageUsers")
public class AdminUserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping ("")
    public String displayManageUsersPage (Model model) {
        List<User> listUsers = userRepository.findAll();
        model.addAttribute("title", "Admin Portal: Manage Users");
        model.addAttribute("listUsers", listUsers);
        model.addAttribute("user", new User());
        return "/admin/manageUsers/index";
    }

    @GetMapping("new")
    public String displayRegisterNewUser(){
        return "/register";
    }

    @GetMapping ("edit/{id}")
    public String displayEditUserPage(@PathVariable("id") Integer id, Model model){
        List<User> listUsers = userRepository.findAll();
        User user = userRepository.findById(id).get();
        model.addAttribute("listUsers", listUsers);
        model.addAttribute("title","Admin Portal: edit User");
        model.addAttribute("button", "Save Changes");
        model.addAttribute("user", user);
        return "/admin/manageUsers/edit";
    }

    @GetMapping ("delete/{id}")
    public String deleteUser (User user) {
        userRepository.delete(user);
        return "redirect:/admin/manageUsers";
    }

    @PostMapping("save")
    public String saveUser (User user) {
        userRepository.save(user);
        return "redirect:/admin/manageUsers";
    }

}
