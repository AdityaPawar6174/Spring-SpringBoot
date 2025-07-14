package com.aditya.MegamartProjectAssignment.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    private String cartId;
    private String productName;
    private String sellerName;
    private int quantity;
    private Double cartOffer_price;
}
