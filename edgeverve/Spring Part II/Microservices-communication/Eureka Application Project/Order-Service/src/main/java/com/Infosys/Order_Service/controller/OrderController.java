package com.Infosys.Order_Service.controller;

import com.Infosys.Order_Service.model.Order;
import com.Infosys.Order_Service.repository.OrderRepo;
import com.Infosys.Order_Service.repository.OrderResponseDTO;
import com.Infosys.Order_Service.repository.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @PostMapping("/placeOrder")
    public Mono<ResponseEntity<OrderResponseDTO>> placeOrder(@RequestBody Order order){
        return webClientBuilder.build().get()
                .uri("http://localhost:8082/products/"+order.getProductId())
                .retrieve()
                .bodyToMono(ProductDTO.class)
                .map(productDto -> {
                    orderRepo.save(order);
                    OrderResponseDTO responseDTO = new OrderResponseDTO();

                    responseDTO.setOrderId(order.getId());
                    responseDTO.setQuantity(order.getQuantity());

                    responseDTO.setProductId(order.getProductId());
                    responseDTO.setProductName(productDto.getName());
                    responseDTO.setProductPrice(productDto.getPrice());
                    responseDTO.setTotalPrice(order.getQuantity() * productDto.getPrice());

                    return ResponseEntity.ok(responseDTO);
                });
    }

    @GetMapping("/allOrders")
    public List<Order> getAllOrders(){
        return orderRepo.findAll();
    }

}
