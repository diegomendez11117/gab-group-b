package com.liftoff.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Faq {



    @Id@GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    private String question;

    private String answer;

    private String link;

    public Faq(){}

    public Faq(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public Faq(String question, String answer, String link) {
        this.question = question;
        this.answer = answer;
        this.link = link;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
