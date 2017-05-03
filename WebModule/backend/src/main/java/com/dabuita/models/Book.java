package com.dabuita.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "title")
    private String title;

    @Column(name= "author")
    String author;

    public Book() {
    }

    public Book(final String id, final String title, final String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Book(final String title, final String author) {
        this.title = title;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(final String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book: " + this.id + ", " + this.title + ", " + this.author;
    }
}
