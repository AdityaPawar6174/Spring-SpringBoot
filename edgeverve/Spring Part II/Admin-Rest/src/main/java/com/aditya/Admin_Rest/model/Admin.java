package com.aditya.Admin_Rest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "admin-info")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adminId;
    @NotEmpty(message = "Admin Name required")
    private String adminName;
    @NotEmpty(message = "Password required")
    private String adminPassword;
}
