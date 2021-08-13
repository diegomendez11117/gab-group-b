package com.liftoff.models;


import javax.persistence.*;

@Entity
public class WantTo {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String description;

//    public enum Priority {
//        HIGH,
//        MEDIUM,
//        LOW,
//        HIDDEN,
//    }
//
//    private Priority priority;


    public WantTo(){}

//    public WantTo(String title, String description, Priority priority) {
//        this.title = title;
//        this.description = description;
//        this.priority = priority;
//    }

    public WantTo(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Integer getId() {
        return id;
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

    @Override
    public String toString() {
        return "WantTo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
