package com.jpats.jpats.entity;

import javax.persistence.*;

@Entity
@Table(name = "sys_book")
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name="book_name",nullable = false)
    private String name;
    
    private String author;
    private Float price;
    
    @Transient
    @Column(name="remark")
    private String description;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public Float getPrice() {
        return price;
    }
    
    public void setPrice(Float price) {
        this.price = price;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
}
