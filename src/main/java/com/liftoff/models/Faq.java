package com.liftoff.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Faq extends AbstractEntity{


    @OneToMany (mappedBy = "faq", cascade = CascadeType.ALL)
    private List<Link> links = new ArrayList<>();

    private String question;

    private String answer;

    public Faq(){}


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


    @Override
    public String toString() {
        return "Faq{" +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
