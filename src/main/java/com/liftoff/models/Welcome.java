package com.liftoff.models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Welcome extends AbstractEntity{

    @Column(name="welcomeParagraph1", columnDefinition="MEDIUMTEXT")
    private String welcomeParagraph1;

    @Column(name="welcomeParagraph2", columnDefinition="MEDIUMTEXT")
    private String welcomeParagraph2;

    @Column(name="welcomeParagraph3", columnDefinition="MEDIUMTEXT")
    private String welcomeParagraph3;

    @Column(name="about1", columnDefinition="MEDIUMTEXT")
    private String about1;

    @Column(name="about2", columnDefinition="MEDIUMTEXT")
    private String about2;

    @Column(name="about3", columnDefinition="MEDIUMTEXT")
    private String about3;

    @Column(name="highPriorityDescription", columnDefinition="MEDIUMTEXT")
    private String highPriorityDescription;

    @Column(name="mediumPriorityDescription", columnDefinition="MEDIUMTEXT")
    private String mediumPriorityDescription;

    @Column(name="lowPriorityDescription", columnDefinition="MEDIUMTEXT")
    private String lowPriorityDescription;



    public enum PreferredLanguage {
        ENGLISH,
        SPANISH,
        FRENCH,
    }

    private PreferredLanguage preferredLanguage;

    private String mapString;

    public String getWelcomeParagraph1() {
        return welcomeParagraph1;
    }

    public void setWelcomeParagraph1(String welcomeParagraph1) {
        this.welcomeParagraph1 = welcomeParagraph1;
    }

    public String getWelcomeParagraph2() {
        return welcomeParagraph2;
    }

    public void setWelcomeParagraph2(String welcomeParagraph2) {
        this.welcomeParagraph2 = welcomeParagraph2;
    }

    public String getWelcomeParagraph3() {
        return welcomeParagraph3;
    }

    public void setWelcomeParagraph3(String welcomeParagraph3) {
        this.welcomeParagraph3 = welcomeParagraph3;
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

    public String getHighPriorityDescription() {
        return highPriorityDescription;
    }

    public void setHighPriorityDescription(String highPriorityDescription) {
        this.highPriorityDescription = highPriorityDescription;
    }

    public String getMediumPriorityDescription() {
        return mediumPriorityDescription;
    }

    public void setMediumPriorityDescription(String mediumPriorityDescription) {
        this.mediumPriorityDescription = mediumPriorityDescription;
    }

    public String getLowPriorityDescription() {
        return lowPriorityDescription;
    }

    public void setLowPriorityDescription(String lowPriorityDescription) {
        this.lowPriorityDescription = lowPriorityDescription;
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
