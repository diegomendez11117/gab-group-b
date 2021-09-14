package com.liftoff.models;

import javax.persistence.*;

@Entity
@Table (name = "ui")
public class Ui extends AbstractEntity{


    @Column(unique = true, name = "name")
    private String name;

    @Column(name = "text", columnDefinition = "MEDIUMTEXT")
    private String text;

    public Ui(){}

    public Ui(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return name ;
    }

}
