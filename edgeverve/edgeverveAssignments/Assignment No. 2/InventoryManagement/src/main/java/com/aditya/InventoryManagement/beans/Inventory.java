package com.aditya.InventoryManagement.beans;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Table(name = "inventoryTable")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter int productId;
    @NotBlank(message = "Product Name cannot be Empty")
    private @Getter @Setter String productName;
//    @Column(length = 1000)
//    @Lob
    @Column(name = "description", columnDefinition = "TEXT")
    private @Getter @Setter String description;
    @NotNull(message = "price cannot be null")
    private @Getter @Setter int price;
    private @Getter @Setter int stockQuantity;

    public Inventory(int productId, int stockQuantity, int price, String description, String productName) {
        this.productId = productId;
        this.stockQuantity = stockQuantity;
        this.price = price;
        this.description = description;
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stockQuantity=" + stockQuantity +
                '}';
    }
}
