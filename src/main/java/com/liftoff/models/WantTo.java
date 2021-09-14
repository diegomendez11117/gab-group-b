package com.liftoff.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class WantTo extends AbstractEntity{


    @OneToMany (mappedBy = "wantTo", cascade = CascadeType.ALL)
    private List<Link> links = new ArrayList<>();

    @Column(name = "title")
    private String title;

    @Column(name = "description", columnDefinition = "MEDIUMTEXT")
    private String description;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(columnDefinition = "TINYINT")
    private Boolean hidden;

    public enum Priority {
        HIGH,
        MEDIUM,
        LOW,
     }

    private Priority priority;


    public WantTo(){}


    public WantTo(String title, String description, Priority priority,Boolean hidden) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.hidden = hidden;
    }

    public WantTo(String title, String description,Priority priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    public WantTo(String title, String description){
        this.title = title;
        this.description = description;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
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

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    @Override
    public String toString() {
        return title;
    }
}
