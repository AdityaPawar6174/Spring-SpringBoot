package com.aditya.MegamartProjectAssignment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "orders")
public class Order {
    @Id
    private String orderId;
    private String displayName;
    private String category;
    private String seller_name;

    private Double price;
    private int quantity;
    private Double total_price;

    private Date ordered_date;
    private String order_status;
}
