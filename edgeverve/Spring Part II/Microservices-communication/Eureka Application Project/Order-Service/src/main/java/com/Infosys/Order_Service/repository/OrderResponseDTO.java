package com.Infosys.Order_Service.repository;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderResponseDTO {
    private Long orderId;
    private Long productId;
    private int quantity;
    private Double totalPrice;

    private String productName;
    private Double productPrice;
}
