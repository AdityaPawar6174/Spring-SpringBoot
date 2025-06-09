package com.aditya.CustomerRelationshipManagement.beans;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Entity
@Table(name = "interactions")
public class Interaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter int interactionId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private @Getter @Setter Customer customer;

    private @Getter @Setter LocalDate date;
    private @Getter @Setter String notes;

    private @Getter @Setter String product;
    private @Getter @Setter int rating;

    public Interaction(int interactionId, Customer customer, LocalDate date, String notes, String product, int rating) {
        this.interactionId = interactionId;
        this.customer = customer;
        this.date = date;
        this.notes = notes;
        this.product = product;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Interaction{" +
                "interactionId=" + interactionId +
                ", customer=" + customer +
                ", date=" + date +
                ", notes='" + notes + '\'' +
                ", ratedProducts='" + product + '\'' +
                ", rating=" + rating +
                '}';
    }
}
