package com.liftoff.models;

import javax.persistence.*;

@Entity
public class Link {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn (name = "wantTo_id")
    private WantTo wantTo;

    @ManyToOne
    @JoinColumn (name = "faq_id")
    private Faq faq;

    private String name;

    private String url;


    public Link(){}

    public Link(WantTo wantTo, String name, String url) {
        this.wantTo = wantTo;
        this.name = name;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
