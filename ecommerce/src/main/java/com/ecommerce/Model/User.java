package com.ecommerce.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;

    private String email ;

    private String password ;

    private String name = "" ;

    private String city = "";

    private String state = "";

    private String pincode = "";

    private String localAddress = "" ;


    public User(int id, String email, String password, String name, String city, String state, String pincode, String localAddress) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.localAddress = localAddress;
    }

    public User(String email, String password, String name, String city, String state, String pincode, String localAddress) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.localAddress = localAddress;
    }

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getLocalAddress() {
        return localAddress;
    }

    public void setLocalAddress(String localAddress) {
        this.localAddress = localAddress;
    }

    public User(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pincode='" + pincode + '\'' +
                ", localAddress='" + localAddress + '\'' +
                '}';
    }
}
