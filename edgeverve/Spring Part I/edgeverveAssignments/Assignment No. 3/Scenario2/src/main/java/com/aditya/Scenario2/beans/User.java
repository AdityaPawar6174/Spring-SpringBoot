package com.aditya.Scenario2.beans;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users") // Table name is 'users' in the database
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @NotBlank(message = "Name cannot be empty")
    private String userName;
    @NotBlank(message = "password cannot be empty")
    private String password;

    // one-to-one relationship... User <---> Profile
    @OneToOne(mappedBy = "user" ,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Profile profile;

    // one-to-many relationship... User <--->> Order
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Order> orders = new ArrayList<>();

    // constructors
    public User(){}

    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    // getters and setters
    public int getId() {
        return userId;
    }

    public void setId(int userId) {
        this.userId = userId;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    // ToString method
    @Override
    public String toString() {
        return "Users{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", id=" + userId +
                '}';
    }
}
