package com.liftoff.models;

public class Welcome {

        public String welcomeMessage = "Every year many refugee migrants arrive in Saint Louis from other parts of the world. It is essential for them to settle in a new community and start a new life. To all this, some problems arise, such as: obtaining personal documentation like driver license, work permit, Social Security Number, information for minors regarding the continuity of academic studies, language learning, also alternatives for adults to obtain a job, government aid, financial information for obtaining loans and credit. These are some of the many other problems that can affect the development of the life of a refugee in the United States and specifically in the city of Saint Louis.\n" +
                "Due to the problem of lack of information, we can consider the idea of creating an information help center for immigrants, which interacts with each user, providing all the information tools (links, phone numbers, addresses, and tips) so that they can advance in the beginning of a new life in a brand-new place.";

        public int zip;

        public enum PreferredLanguage {
            ENGLISH,
            SPANISH,
            FRENCH,
        }

        public PreferredLanguage preferredLanguage;

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public PreferredLanguage getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(PreferredLanguage preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }
}
