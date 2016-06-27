package com.example.Entities;

import javax.persistence.*;

/**
 * Created by illladell on 6/27/16.
 */

@Entity
@Table (name = "users")
public class User {

    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String Username;

    @Column(nullable = false)
    String address;

    @Column(nullable = false)
    String email;

    public User() {
    }

    public User(String username, String address, String email) {
        Username = username;
        this.address = address;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
