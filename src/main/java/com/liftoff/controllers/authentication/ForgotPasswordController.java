package com.liftoff.controllers.authentication;

import com.liftoff.controllers.Utility;
import com.liftoff.models.User;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.sound.midi.MidiMessage;
import java.io.UnsupportedEncodingException;

@Controller
public class ForgotPasswordController {

    @Autowired
    private AuthenticationServices service;

    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("/forgot_password")
    public String showForgotPasswordForm(Model model){
        model.addAttribute("title", "Forgot Password");
        return "forgot_password";
    }

    @PostMapping("/forgot_password")
    public  String processForgotPasswordForm(HttpServletRequest request, Model model) {

        String email = request.getParameter("email");
        String token = RandomString.make(45);

        try {
            service.updateResetPasswordToken(token, email);
            String resetPasswordLink = Utility.getSiteURL(request) + "/resetPassword?token=" + token;
            System.out.println("Reset Password Link: " + resetPasswordLink);
            sendEmail(email, resetPasswordLink);
            model.addAttribute("message", "An email with a password reset " +
                    "link has been sent. Please check your e-amil." );

        } catch (Utility.CustomerNotFoundException ex) {
            model.addAttribute("error", ex.getMessage());
        } catch (MessagingException e) {
            model.addAttribute("error", "Error while sending e-mail");
        } catch (UnsupportedEncodingException e) {
            model.addAttribute("error", "Error while sending e-mail");
        }

        System.out.println("Email: " + email);
        System.out.println("Token: " + token);
        return "forgot_password";
    }

    @PostMapping("reset_password")
    public String showResetPasswordForm(@Param(value="token") String token,
                                        Model model){
        User user = service.get(token);
        if (user == null) {
            model.addAttribute("title", "Reset your Password");
            model.addAttribute("message", "Invalid Token");
            return "message";
        }
        model.addAttribute("token",token);
        model.addAttribute("pageTitle", "Reset Your Password");
        return ("reset_password");
    }

    private void sendEmail(String email, String resetPasswordLink)
            throws MessagingException, UnsupportedEncodingException {

        String toAddress = email;
        String fromAddress = "stlwelcomesyou@gmail.com";
        String senderName = "Welcome STL";
        String subject = "Here is the link to reset your password";
        String content = "<p> Hello,</p>"
                + "<p>You recently submitted a request your password</p>"
                + "<p>Click on the link below to update your password</p>"
                + "<h3><a href=\"" + resetPasswordLink + "\">Change my Password</a></h3>"
                + "<p>If you remember your password or did not make this request, please ignore this email</p>";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);
        helper.setText(content, true);

        mailSender.send(message);
    }



}
