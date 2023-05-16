package com.ecommerce.Model;

import jakarta.persistence.*;

@Entity
public class myOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;

    @Column(length = 2000)
    private String details ; // here store what all things have been ordered

    private String amount ; // it is stored in paisa

    @Column(length = 1000)
    private String address ; // order address

    private String paymentId ;

    private String orderId ;

    public myOrder(int id, String details, String amount, String address, String paymentId, String orderId) {
        this.id = id;
        this.details = details;
        this.amount = amount;
        this.address = address;
        this.paymentId = paymentId;
        this.orderId = orderId;
    }

    public myOrder() {
    }

    public myOrder(String details, String amount, String address, String paymentId, String orderId) {
        this.details = details;
        this.amount = amount;
        this.address = address;
        this.paymentId = paymentId;
        this.orderId = orderId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", details='" + details + '\'' +
                ", amount='" + amount + '\'' +
                ", address='" + address + '\'' +
                ", paymentId='" + paymentId + '\'' +
                ", orderId='" + orderId + '\'' +
                '}';
    }
}
