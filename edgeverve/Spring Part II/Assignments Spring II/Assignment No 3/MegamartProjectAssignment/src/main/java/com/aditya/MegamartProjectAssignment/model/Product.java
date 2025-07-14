package com.aditya.MegamartProjectAssignment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;
    private String productName;
    private String description;
    private Double price;
    private Double discount;
    private Double delivery_charges;
    private int Avg_rating;
    private String seller_name;

    @Override
    public String toString() {
        return "\n{" +
                "\nproductId=" + productId +
                ", \nproductName='" + productName + '\'' +
                ", \ndescription='" + description + '\'' +
                ", \nprice=" + price +
                ", \ndiscount=" + discount +
                ", \ndelivery_charges=" + delivery_charges +
                ", \nAvg_rating=" + Avg_rating +
                ", \nseller_name='" + seller_name + '\'' + "\n" +
                '}';
    }
}
