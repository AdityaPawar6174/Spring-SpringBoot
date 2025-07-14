package com.aditya.MegamartProjectAssignment.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
@Table(name = "account")
public class Account {
    @Id
    @NotBlank(message = "Username cannot be blank")
    private String name;
    @Email(message = "Invalid email format")
    @Column(nullable = false)
    private String email;
    @NotBlank( message = "Password cannot be blank")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;
    @Transient // not saved in DB, used during registration only
    private String confirmPassword;
}
