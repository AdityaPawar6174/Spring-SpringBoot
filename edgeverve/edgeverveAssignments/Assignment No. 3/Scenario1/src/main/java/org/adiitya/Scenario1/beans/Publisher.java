package org.adiitya.Scenario1.beans;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "publishers")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter int id;

    @NotBlank(message = "Publisher name is required")
    private @Getter @Setter String name;

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
    private @Getter @Setter List<Book> books = new ArrayList<>();
}