package com.practice.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {

    @Id
    @NotBlank(message = "ISBN is required")
    @Size(min = 13, max = 13, message = "ISBN must be 13 digits long")
    @Column(name = "isbn", nullable = false, unique = true)
    private String isbn;

    @NotBlank(message = "Title is required")
    @Column(name = "title", nullable = false)
    private String title;

    @NotBlank(message = "Author is required")
    @Column(name = "author", nullable = false)
    private String author;

}
