package com.ecommerce.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private int id ;

    private String name ;

    @Column(length = 2000)
    private String img_url ;

    @Column(length = 2000)
    private String details ;

    private String price ;

    private String category ;

    public Product(int id, String name, String img_url, String details, String price, String category) {
        this.id = id;
        this.name = name;
        this.img_url = img_url;
        this.details = details;
        this.price = price;
        this.category = category;
    }

    public Product(String name, String img_url, String details, String price, String category) {
        this.name = name;
        this.img_url = img_url;
        this.details = details;
        this.price = price;
        this.category = category;
    }

    public Product() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", img_url='" + img_url + '\'' +
                ", details='" + details + '\'' +
                ", price='" + price + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
