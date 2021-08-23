package com.liftoff.models;

import javax.persistence.Entity;

@Entity
public class Welcome extends AbstractEntity{

    private String paragraph1;
    private String paragraph2;
    private String paragraph3;
    private String about1;
    private String about2;
    private String about3;


    public enum PreferredLanguage {
        ENGLISH,
        SPANISH,
        FRENCH,
    }

    private PreferredLanguage preferredLanguage;

    private String mapString;




    public String getParagraph1() {
        return paragraph1;
    }

    public void setParagraph1(String paragraph1) {
        this.paragraph1 = paragraph1;
    }

    public String getParagraph2() {
        return paragraph2;
    }

    public void setParagraph2(String paragraph2) {
        this.paragraph2 = paragraph2;
    }

    public String getParagraph3() {
        return paragraph3;
    }

    public void setParagraph3(String paragraph3) {
        this.paragraph3 = paragraph3;
    }

    public String getAbout1() {
        return about1;
    }

    public void setAbout1(String about1) {
        this.about1 = about1;
    }

    public String getAbout2() {
        return about2;
    }

    public void setAbout2(String about2) {
        this.about2 = about2;
    }

    public String getAbout3() {
        return about3;
    }

    public void setAbout3(String about3) {
        this.about3 = about3;
    }

    public PreferredLanguage getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(PreferredLanguage preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }

    public String getMapString() {
        return mapString;
    }

    public void setMapString(String mapString) {
        this.mapString = mapString;
    }
}
