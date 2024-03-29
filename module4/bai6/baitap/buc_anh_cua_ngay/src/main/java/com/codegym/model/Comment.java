package com.codegym.model;



import javax.persistence.*;

@Table
@Entity
public class Comment{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int mark;
    private String author;
    private String feedback;
    private int totalLike=0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }


    public int getTotalLike() {
        return totalLike;
    }


    public void setTotalLike(int totalLike) {
        this.totalLike = totalLike;
    }
}