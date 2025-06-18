package org.adiitya.Scenario1.beans;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "branches")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LibraryBranch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter int id;

    @NotBlank(message = "Branch name is mandatory")
    private @Getter @Setter String name;

    private @Getter @Setter String location;

    private @Getter @Setter List<Book> books = new ArrayList<>();

}
