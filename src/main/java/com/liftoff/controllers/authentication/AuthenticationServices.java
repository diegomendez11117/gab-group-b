package com.liftoff.controllers.authentication;

import com.liftoff.controllers.Utility;
import com.liftoff.models.Role;
import com.liftoff.models.User;
import com.liftoff.models.data.RoleRepository;
import com.liftoff.models.data.UserRepository;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.io.UnsupportedEncodingException;
import java.util.Optional;

@Service
public class AuthenticationServices {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;


    public void register(User user, String siteURL)
            throws UnsupportedEncodingException, MessagingException {

        String randomCode = RandomString.make(64);
        user.setVerificationCode(randomCode);
        user.setEnabled(false);

        Role role = roleRepository.getById(1);
        user.addRole(role);

        userRepository.save(user);
        sendVerificationEmail(user, siteURL);
            System.out.println("AuthServices.register --- saved:" + user);
    }


    private void sendVerificationEmail(User user, String siteURL)
            throws MessagingException, UnsupportedEncodingException {
        String toAddress = user.getEmail();
        String fromAddress = "stlwelcomesyou@gmail.com";
        String senderName = "Welcome STL";
        String subject = "Please verify your registration";
        String content = "Dear [[username]],<br>"
                + "Please click the link below to verify your registration:<br>"
                + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
                + "Thank you,<br>"
                + "Welcome STL.";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);

        content = content.replace("[[username]]", user.getUsername());
        String verifyURL = siteURL + "/verify?code=" + user.getVerificationCode();

        content = content.replace("[[URL]]", verifyURL);

        helper.setText(content, true);

        mailSender.send(message);
            System.out.println("SENT VERIFICATION EMAIL - authenticationServices.sendVerificationEmail");
    }

    public boolean verify(String verificationCode) {
        User user = userRepository.findByVerificationCode(verificationCode);

        if (user == null || user.isEnabled()) {
            System.out.println("AuthServices.verify: User is null/enabled: " + user);
            return false;
        } else {
            user.setVerificationCode(null);
            user.setEnabled(true);
            userRepository.save(user);
            System.out.println("AuthServices.verify: User has been verified.  user:" + user +
                    " enabled: " +  " verification code:" + user.getVerificationCode());
            return true;
        }
   }

   public void updateResetPasswordToken(String token, String email) throws Utility.CustomerNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            user.setResetPasswordToken(token);
            userRepository.save(user);
        } else {
            throw new Utility.CustomerNotFoundException("Could not find any customer with email " + email);
        }
   }

    public User getByResetPasswordToken(String resetPasswordToken) {
        return userRepository.findByResetPasswordToken(resetPasswordToken);
    }

    public void updatePassword(User user, String newPassword){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);

        user.setPassword(encodedPassword);
        user.setResetPasswordToken(null);

        userRepository.save(user);
    }
}
