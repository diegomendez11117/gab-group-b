package com.liftoff.controllers;

import com.liftoff.models.Welcome;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("")
public class WelcomeController {


    public int zip;

    public enum PreferredLanguage {
        ENGLISH,
        SPANISH,
        FRENCH,
    }

    public Welcome.PreferredLanguage preferredLanguage;

    @GetMapping ("")
    public String displayWelcome(Model model) {
        String welcomeMessage = "Every year many refugee migrants arrive in" +
                " Saint Louis from other parts of the world. It is essential for them" +
                " to settle in a new community and start a new life. To all this," +
                " some problems arise, such as: obtaining personal documentation" +
                " like driver license, work permit, Social Security Number," +
                " information for minors regarding the continuity" +
                " of academic studies,language learning, also alternatives for adults" +
                " to obtain a job, government aid, financial information" +
                " for obtaining loans and credit. These are some of the many other" +
                " problems that can affect the development of the life of a refugee" +
                " in the United States and specifically in the city of Saint Louis." +
                " Due to the problem of lack of information, we can consider" +
                " the idea of creating an information help center for immigrants," +
                " which interacts with each user, providing all the information" +
                " tools (links, phone numbers, addresses, and tips) so that they can" +
                " advance in the beginning of a new life in a brand-new place.";

        model.addAttribute("welcomeMessage", welcomeMessage);
        model.addAttribute("title", "Welcome!");
        return "/welcome/index";
    }

    @GetMapping ("about")
    public String displayAboutUs(Model model) {
    String aboutMessage = "Enrique SUPed from Cuba to Texas, camped in a closet," +
            " visited the aliens in New Mexico, camped in another closet, " +
            "traveled to California to eat raisins, and then camped in yet another closet." +
            " There has to be an easier way to eat raisins with an Alien.";

        model.addAttribute("aboutMessage", aboutMessage);
        model.addAttribute("title", "About Us!");

        return "/about";
    }
}
