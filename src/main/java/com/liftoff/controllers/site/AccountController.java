package com.liftoff.controllers.site;

import com.liftoff.models.User;
import com.liftoff.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;


@Controller
@RequestMapping("account")
public class AccountController {

    @Autowired
    UserRepository userRepository;

    @GetMapping ("")
    public String displayAdminPortalLandingPage(HttpServletRequest request, Model model) {

        String username = request.getRemoteUser();
        User user = userRepository.findByUsername(username);
        System.out.println(username);
        model.addAttribute("user", user);
        model.addAttribute("title", "Admin Portal:");
        return "/account/index";
    }


}
