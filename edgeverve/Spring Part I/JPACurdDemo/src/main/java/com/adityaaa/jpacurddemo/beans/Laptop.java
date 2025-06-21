package com.adityaaa.jpacurddemo.beans;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "tb_laptop")
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter int macId;

    @NotBlank(message = "laptop model name required")
    private @Getter @Setter String modelName;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Laptop.class)
    Student student;

}
