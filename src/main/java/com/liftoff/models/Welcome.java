package com.liftoff.models;

public class Welcome {

        public String welcomeMessage;

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
