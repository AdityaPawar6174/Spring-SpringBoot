package org.adiitya.Scenario1.beans;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter int id;

    @NotBlank(message = "Author name must be provided")
    private @Getter @Setter String name;

    @ManyToMany(mappedBy = "authors")
    private @Getter @Setter List<Book> books = new ArrayList<>();
}
