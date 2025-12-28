package com.example.test;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

import java.util.Arrays;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String info;
    private double price;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String country;
    private String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<String> getCountry() {
        return Arrays.asList(
                "United States",
                "Canada",
                "United Kingdom",
                "Australia"
        );
    }
　
    public void setCountry(String country) {
        this.country = country;
    }

    public Product(String name, double price, String info, Date date, String country, String gender) {
        this.name = name;
        this.price = price;
        this.info = info;
        this.date = date;
        this.country = country;
        this.gender = gender;
        ;
    }

    public Product() {
    }
}
