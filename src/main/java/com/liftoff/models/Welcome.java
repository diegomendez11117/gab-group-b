package com.liftoff.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

@Entity
public class Welcome extends AbstractEntity {

    @Column(name = "welcomeParagraph1", columnDefinition = "MEDIUMTEXT")
    private String welcomeParagraph1;

    @Column(name = "welcomeParagraph2", columnDefinition = "MEDIUMTEXT")
    private String welcomeParagraph2;

    @Column(name = "welcomeParagraph3", columnDefinition = "MEDIUMTEXT")
    private String welcomeParagraph3;



    @Column(name = "about1Title")
    private String about1Title;

    @Column(name = "about1Description", columnDefinition = "MEDIUMTEXT")
    private String about1Description;

    @Column(name = "about2Title")
    private String about2Title;

    @Column(name = "about2Description", columnDefinition = "MEDIUMTEXT")
    private String about2Description;

    @Transient
    String[] developers
            = { "Dennis Sheets: backend - Java & MySQL", "Enrique Mendez Roger: frontend - BootStrap, HTML,& CSS"};

    @Column(name = "about3Title")
    private String about3Title;

    @Column(name = "about3Description", columnDefinition = "MEDIUMTEXT")
    private String about3Description;


    @Transient
    String[] organizations
            = { "Organization ABD: contact ABC", "Organization 123: contact 123", "Organization!@#: contact!@#"};


    @Column(name = "highPriorityTitle")
    private String highPriorityTitle;

    @Column(name = "highPriorityDescription", columnDefinition = "MEDIUMTEXT")
    private String highPriorityDescription;

    @Column(name = "mediumPriorityTitle")
    private String mediumPriorityTitle;

    @Column(name = "mediumPriorityDescription", columnDefinition = "MEDIUMTEXT")
    private String mediumPriorityDescription;

    @Column(name = "lowPriorityTitle")
    private String lowPriorityTitle;

    @Column(name = "lowPriorityDescription", columnDefinition = "MEDIUMTEXT")
    private String lowPriorityDescription;

    private String mapString;


    public Welcome() {}


    public String[] getDevelopers() {
        return developers;
    }

    public void setDevelopers(String[] developers) {
        this.developers = developers;
    }

    public String[] getOrganizations() {
        return organizations;
    }

    public void setOrganizations(String[] organizations) {
        this.organizations = organizations;
    }

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

    public String getAbout1Title() {
        return about1Title;
    }

    public void setAbout1Title(String about1Title) {
        this.about1Title = about1Title;
    }

    public String getAbout1Description() {
        return about1Description;
    }

    public void setAbout1Description(String about1Description) {
        this.about1Description = about1Description;
    }

    public String getAbout2Title() {
        return about2Title;
    }

    public void setAbout2Title(String about2Title) {
        this.about2Title = about2Title;
    }

    public String getAbout2Description() {
        return about2Description;
    }

    public void setAbout2Description(String about2Description) {
        this.about2Description = about2Description;
    }

    public String getAbout3Title() {
        return about3Title;
    }

    public void setAbout3Title(String about3Title) {
        this.about3Title = about3Title;
    }

    public String getAbout3Description() {
        return about3Description;
    }

    public void setAbout3Description(String about3Description) {
        this.about3Description = about3Description;
    }

    public String getHighPriorityTitle() {
        return highPriorityTitle;
    }

    public void setHighPriorityTitle(String highPriorityTitle) {
        this.highPriorityTitle = highPriorityTitle;
    }

    public String getHighPriorityDescription() {
        return highPriorityDescription;
    }

    public void setHighPriorityDescription(String highPriorityDescription) {
        this.highPriorityDescription = highPriorityDescription;
    }

    public String getMediumPriorityTitle() {
        return mediumPriorityTitle;
    }

    public void setMediumPriorityTitle(String mediumPriorityTitle) {
        this.mediumPriorityTitle = mediumPriorityTitle;
    }

    public String getMediumPriorityDescription() {
        return mediumPriorityDescription;
    }

    public void setMediumPriorityDescription(String mediumPriorityDescription) {
        this.mediumPriorityDescription = mediumPriorityDescription;
    }

    public String getLowPriorityTitle() {
        return lowPriorityTitle;
    }

    public void setLowPriorityTitle(String lowPriorityTitle) {
        this.lowPriorityTitle = lowPriorityTitle;
    }

    public String getLowPriorityDescription() {
        return lowPriorityDescription;
    }

    public void setLowPriorityDescription(String lowPriorityDescription) {
        this.lowPriorityDescription = lowPriorityDescription;
    }

    public String getMapString() {
        return mapString;
    }

    public void setMapString(String mapString) {
        this.mapString = mapString;
    }
}
