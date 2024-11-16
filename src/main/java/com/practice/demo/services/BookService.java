package com.practice.demo.services;

import com.practice.demo.dtos.BookCreateDTO;
import com.practice.demo.dtos.BookDTO;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<BookDTO> findAll();
    Optional<BookDTO> findByIsbn(String isbn);
    BookDTO createBook(BookCreateDTO bookCreateDTO);
    Optional<BookDTO> updateBook(BookDTO bookDTO);
    boolean deleteBook(String isbn);
}
