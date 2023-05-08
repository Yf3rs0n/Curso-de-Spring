package com.example.obrestdatajpa.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
//tabla
@Table(name ="books")
public class Book {
    // atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tittle;
    private String author;
    private Integer pages;
    private Double price;
    private LocalDate realeseDate;
    private Boolean online;

    //constructores

    public Book() {
    }

    public Book(Long id, String tittle, String author, Integer pages, Double price, LocalDate realeseDate, Boolean online) {
        this.id = id;
        this.tittle = tittle;
        this.author = author;
        this.pages = pages;
        this.price = price;
        this.realeseDate = realeseDate;
        this.online = online;
    }

    // getter y setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getRealeseDate() {
        return realeseDate;
    }

    public void setRealeseDate(LocalDate realeseDate) {
        this.realeseDate = realeseDate;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }
}
