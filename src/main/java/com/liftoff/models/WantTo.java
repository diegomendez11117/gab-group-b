package com.liftoff.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class WantTo extends AbstractEntity{


    @OneToMany (mappedBy = "wantTo", cascade = CascadeType.ALL)
    private List<Link> links = new ArrayList<>();

    private String title;

    private String description;

    private Priority priority;

    public enum Priority {
        HIGH,
        MEDIUM,
        LOW,
        HIDDEN,
    }


    public WantTo(){}

    public WantTo(String title, String description, Priority priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    public WantTo(String title, String description) {
        this.title = title;
        this.description = description;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }


    @Override
    public String toString() {
        return "WantTo{" +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
