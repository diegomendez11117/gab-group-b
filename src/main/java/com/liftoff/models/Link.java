package com.liftoff.models;

import javax.persistence.*;

@Entity
public class Link extends AbstractEntity{


    @ManyToOne
    @JoinColumn (name = "wantTo_id")
    private WantTo wantTo;

    @ManyToOne
    @JoinColumn (name = "faq_id")
    private Faq faq;

    private String name;

    private String url;

    private String guideStarUrl;


    public Link(){}

    public Link(WantTo wantTo, String name, String url) {
        this.wantTo = wantTo;
        this.name = name;
        this.url = url;
    }

    public WantTo getWantTo() {
        return wantTo;
    }

    public void setWantTo(WantTo wantTo) {
        this.wantTo = wantTo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Faq getFaq() {
        return faq;
    }

    public void setFaq(Faq faq) {
        this.faq = faq;
    }

    public String getGuideStarUrl() {
        return guideStarUrl;
    }

    public void setGuideStarUrl(String guideStarUrl) {
        this.guideStarUrl = guideStarUrl;
    }

    @Override
    public String toString() {
        return "Link{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
