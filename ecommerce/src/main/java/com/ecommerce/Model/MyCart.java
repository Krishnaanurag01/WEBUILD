package com.ecommerce.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MyCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id ;


    int product_id ;

    int quantity ;

    public MyCart(int id, int product_id, int quantity) {
        this.id = id;
        this.product_id = product_id;
        this.quantity = quantity;
    }

    public MyCart() {
    }

    public MyCart(int product_id, int quantity) {
        this.product_id = product_id;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "MyCart{" +
                "id=" + id +
                ", product_id=" + product_id +
                ", quantity=" + quantity +
                '}';
    }
}
