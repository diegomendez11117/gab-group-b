package com.liftoff.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
public class Faq extends AbstractEntity{

    @Column(name = "question", columnDefinition = "MEDIUMTEXT")
    private String question;

    @Column(name = "answer", columnDefinition = "MEDIUMTEXT")
    private String answer;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(columnDefinition = "TINYINT")
    private Boolean hidden;

    public enum ColumnSetting {
        LEFT,
        MIDDLE,
        RIGHT,
    }

    private ColumnSetting columnSetting;


    @OneToMany (mappedBy = "faq", cascade = CascadeType.ALL)
    private List<Link> links = new ArrayList<>();

    public Faq(){}

    public Faq(String question, String answer,Boolean hidden) {
        this.question = question;
        this.answer = answer;
        this.hidden = hidden;
    }

    public Faq(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public ColumnSetting getColumnSetting() {
        return columnSetting;
    }

    public void setColumnSetting(ColumnSetting columnSetting) {
        this.columnSetting = columnSetting;
    }

    @Override
    public String toString() {
        return question;
    }

}
