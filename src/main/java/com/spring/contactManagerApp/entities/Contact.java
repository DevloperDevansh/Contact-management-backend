package com.spring.contactManagerApp.entities;


import jakarta.persistence.*;

@Entity  //Make class as a entity class and map to db table
public class Contact {

    //make this id as primary key in db
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id will create in sequence form like(1 2 3)
    private int contactId;
    @Column(name = "user_name")
    private String name;
    @Column(name="user_email" , nullable = false)
    private String email;
    @Column(name = "user_phone")
    private String phone;

    //create default constructor
    public Contact() {
    }

    //create parameterized constructor

    public Contact(int contactId, String name, String email, String phone) {
        this.contactId = contactId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    //Generate getter & setter to access this class data
    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
