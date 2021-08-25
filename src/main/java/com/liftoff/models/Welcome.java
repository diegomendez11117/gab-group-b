package com.liftoff.models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Welcome extends AbstractEntity{

    @Column(name="paragraph1", columnDefinition="MEDIUMTEXT")
    private String paragraph1;

    @Column(name="paragraph2", columnDefinition="MEDIUMTEXT")
    private String paragraph2;

    @Column(name="paragraph3", columnDefinition="MEDIUMTEXT")
    private String paragraph3;

    @Column(name="about1", columnDefinition="MEDIUMTEXT")
    private String about1;

    @Column(name="about2", columnDefinition="MEDIUMTEXT")
    private String about2;

    @Column(name="about3", columnDefinition="MEDIUMTEXT")
    private String about3;

    @Column(name="portal1", columnDefinition="MEDIUMTEXT")
    private String portal1;

    @Column(name="portal2", columnDefinition="MEDIUMTEXT")
    private String portal2;

    @Column(name="portal3", columnDefinition="MEDIUMTEXT")
    private String portal3;



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

    public String getPortal1() {
        return portal1;
    }

    public void setPortal1(String portal1) {
        this.portal1 = portal1;
    }

    public String getPortal2() {
        return portal2;
    }

    public void setPortal2(String portal2) {
        this.portal2 = portal2;
    }

    public String getPortal3() {
        return portal3;
    }

    public void setPortal3(String portal3) {
        this.portal3 = portal3;
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
