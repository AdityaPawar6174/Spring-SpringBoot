package com.aditya.Admin_Rest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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
    @Size(min = 8, max = 16, message = "Password must be greater than 8 and less than 16")
    private String adminPassword;
}
