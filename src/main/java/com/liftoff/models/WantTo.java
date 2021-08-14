package com.liftoff.models;


import javax.persistence.*;
import java.util.Objects;

@Entity
public class WantTo {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String description;

    public enum Priority {
        HIGH,
        MEDIUM,
        LOW,
        HIDDEN,
    }

    private Priority priority;


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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WantTo wantTo = (WantTo) o;
        return Objects.equals(id, wantTo.id) && Objects.equals(title, wantTo.title) && Objects.equals(description, wantTo.description) && priority == wantTo.priority;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, priority);
    }

    @Override
    public String toString() {
        return "WantTo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                '}';
    }
}
