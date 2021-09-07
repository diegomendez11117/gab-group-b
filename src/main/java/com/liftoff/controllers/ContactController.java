package com.liftoff.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ContactController {

    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("/contact")
    public String showContactForm() {
        return "contact";
    }

    @PostMapping("/contact")
    public String submitContact(HttpServletRequest request){
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("stlwelcomesyou@gmail.com");
        message.setTo("stlwelcomesyou@gmail.com");

        String mailSubject = fullname + " has sent a message";
        String mailContent = "Sender Name: " + fullname + "\n";
            mailContent += "Sender email: " + email + "\n";
            mailContent += "Subject: " + subject + "\n";
            mailContent += "Content: " + content + "\n";

        message.setSubject(mailSubject);
        message.setText(mailContent);

        mailSender.send(message);


        return "message";
    }
}
