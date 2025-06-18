package org.adiitya.Scenario1.beans;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter int id;

    @NotBlank(message = "Book title is important")
    private @Getter @Setter String title;


    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private @Getter @Setter Publisher publisher;

    @ManyToMany
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private @Getter @Setter List<Author> authors = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "book_branch",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "branch_id")
    )
    private @Getter @Setter List<LibraryBranch> branches = new ArrayList<>();
}
