package com.practice.demo.repository;


import com.practice.demo.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    Optional<Book> findByIsbn(String isbn);

    Optional<Book> findByTitle(String title);

    Optional<Book> findByAuthor(String author);
}
