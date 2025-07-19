package com.aditya.MegamartProjectAssignment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "wishlist")
public class Wishlist {
    @Id
    private String wishId;
    private String displayName;
    private String shortDescription;
    private String category;
}
