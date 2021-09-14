package com.liftoff.controllers.authentication;

import com.liftoff.controllers.Utility;
import com.liftoff.models.User;
import com.liftoff.models.data.UserRepository;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    private UserRepository userRepository;



    @GetMapping("/forgot_password")
    public String showForgotPasswordForm(Model model){
        model.addAttribute("title", "Forgot Password");
        return "forgot_password";
    }



    @PostMapping("/forgot_password")        // User initiated from login form
    public  String processForgotPasswordFormUserReset(HttpServletRequest request, Model model) {

        String email  = request.getParameter("email");
        String token = RandomString.make(45);

        try {
            service.updateResetPasswordToken(token, email);
            String resetPasswordLink = Utility.getSiteURL(request) + "/reset_password?token=" + token;
            sendEmail(email, resetPasswordLink);
            model.addAttribute("message", "An email with a password reset " +
                    "link has been sent. Please check your e-amil." );

        } catch (Utility.CustomerNotFoundException ex) {
            model.addAttribute("error", ex.getMessage());
        } catch (MessagingException | UnsupportedEncodingException e) {
            model.addAttribute("error", "Error while sending e-mail");
        }
        return "forgot_password";
    }

    @GetMapping("/forgot_password/{id}")      // Admin initiated from Admin Tool: User Management
    public  String processForgotPasswordFormAdminRest(@PathVariable("id") Integer id,
                                                      HttpServletRequest request, Model model) {

        String email  = userRepository.getById(id).getEmail();
        String token = RandomString.make(45);

        try {
            service.updateResetPasswordToken(token, email);
            String resetPasswordLink = Utility.getSiteURL(request) + "/reset_password?token=" + token;
            sendEmail(email, resetPasswordLink);
            model.addAttribute("message", "An email with a password reset " +
                    "link has been sent. Please check your e-amil." );

        } catch (Utility.CustomerNotFoundException ex) {
            model.addAttribute("error", ex.getMessage());
        } catch (MessagingException | UnsupportedEncodingException e) {
            model.addAttribute("error", "Error while sending e-mail");
        }
        return "forgot_password";
    }




    @GetMapping("reset_password")
    public String showResetPasswordForm(@Param(value="token") String token,
                                        Model model){
        User user = service.getByResetPasswordToken(token);
        model.addAttribute("title", "Reset your Password");
        if (user == null) {
            model.addAttribute("message", "Invalid Token - Unknown User");
            return "/message";
        } else {
            model.addAttribute("token", token);
            return ("/reset_password");
        }
    }


    @PostMapping("reset_password")
    public String processResetPassword(HttpServletRequest request, Model model) {
        String token = request.getParameter("token");
        String password = request.getParameter("password");

        User user = service.getByResetPasswordToken(token);
        model.addAttribute("title", "Resetting Password");

        if (user == null) {
            model.addAttribute("message", "Invalid Token - Unknown User");
        } else {
            service.updatePassword(user, password);
            model.addAttribute("message", "You have successfully changed your password.");
        }
        return "/message";
    }


    private void sendEmail(String email, String resetPasswordLink)
            throws MessagingException, UnsupportedEncodingException {

        String fromAddress = "stlwelcomesyou@gmail.com";
        String senderName = "Welcome STL";
        String subject = "Here is the link to reset your password";
        String content = "<p> Hello,</p>"
                + "<p>You recently submitted a request to update your password</p>"
                + "<p>Click on the link below to update your password</p>"
                + "<h3><a href=\"" + resetPasswordLink + "\">Change my Password</a></h3>"
                + "<p>If you remember your password or did not make this request, please ignore this email</p>";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(email);
        helper.setSubject(subject);
        helper.setText(content, true);

        mailSender.send(message);
        System.out.println("SENT PASSWORD RESET EMAIL - ForgotPasswordController.sendEmail ");
    }



}
