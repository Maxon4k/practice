package com.example.ethernetlibraryfeedback.entity;

import jakarta.persistence.*;

@Entity
@Table(name= "contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name ="first_name", nullable = false)
    private String firstName;

    @Column(name ="last_name")
    private String lastName;

    @Column(name ="book")
    private String book;

    @Column(name ="email")
    private String email;

    public Contact() {

    }

    public Contact(String firstName, String lastName, String email) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.book = book;
        this.email = email;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getBook() {
        return book;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}