package com.liftoff.controllers;

import com.liftoff.models.Role;
import com.liftoff.models.User;
import com.liftoff.models.data.RoleRepository;
import com.liftoff.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("account/manageUsers")
public class AdminUserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    @GetMapping ("")
    public String displayManageUsersPage (Model model) {
        List<User> listUsers = userRepository.findAll();
        model.addAttribute("title", "Admin Portal: Manage Users");
        model.addAttribute("listUsers", listUsers);
        model.addAttribute("user", new User());
        return "/account/manageUsers/index";
    }

    @GetMapping("new")
    public String displayRegisterNewUser(){
        return "/register";
    }

    @GetMapping ("edit/{id}")
    public String displayEditUserPage(@PathVariable("id") Integer id, Model model){
        if (userRepository.existsById(id)) {
            List<User> listUsers = userRepository.findAll();
            List<Role> listRoles = roleRepository.findAll();
            User user = userRepository.findById(id).get();
            System.out.println("Attempting to edit user: " + user);
            model.addAttribute("listUsers", listUsers);
            model.addAttribute("listRoles", listRoles);
            model.addAttribute("title", "Admin Portal: edit User");
            model.addAttribute("button", "Save Changes");
            model.addAttribute("user", user);
            System.out.println("Edited user: " + user);
            return "/account/manageUsers/edit";
        } else {
            return "/500";
        }
    }

    @GetMapping("reset/{id}")
    public String passwordReset (@PathVariable("id") Integer id) {
        if (userRepository.existsById(id)) {
            User user = userRepository.getById(id);
            System.out.println("Attempting to reset password: " + user);
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String resetPassword = "welcome";
            String encodedPassword = encoder.encode(resetPassword);
            user.setPassword(encodedPassword);
            System.out.println("Routing to Save : " + user);
            return "/account/manageUsers/save}";
        } else {
            System.out.println("FAILED TO RESET: USER DOES NOT EXIST");
            return "/500";
        }
    }

    @GetMapping ("delete/{id}")
    public String deleteUser (@PathVariable("id") Integer id) {
        User user = userRepository.getById(id);
        System.out.println("Attempting to delete user: " + user);
        if (userRepository.existsById(id)) {
            userRepository.delete(user);
            System.out.println("Deleted user: " + user);
            return "/account/manageUsers/index";
        } else {
            System.out.println("FAILED TO DELETE: USER DOES NOT EXIST");
            return "/500";
        }
    }

    @PostMapping("save")
    public String saveUser (User user) {
        System.out.println("Saved/Updated User : " + user);
        userRepository.save(user);
        return "/account/manageUsers/index";
    }


}
