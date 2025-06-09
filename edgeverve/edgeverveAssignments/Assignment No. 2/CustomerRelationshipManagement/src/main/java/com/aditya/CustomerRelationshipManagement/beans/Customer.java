package com.aditya.CustomerRelationshipManagement.beans;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter int customerId;

    @NotBlank
    private @Getter @Setter String name;

    private @Getter @Setter String email;
    private @Getter @Setter String phone;
    private @Getter @Setter String address;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Interaction> interactions = new ArrayList<>();

    public Customer(int customerId, String name, String email, String address, String phone) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
