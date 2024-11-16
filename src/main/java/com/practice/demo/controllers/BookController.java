package com.practice.demo.controllers;

import com.practice.demo.dtos.BookCreateDTO;
import com.practice.demo.dtos.BookDTO;
import com.practice.demo.services.BookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDTO>> findAll() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<BookDTO> findByIsbn(@PathVariable String isbn) {
        return bookService.findByIsbn(isbn)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BookDTO> createBook(@Valid @RequestBody BookCreateDTO bookCreateDTO) {
        BookDTO createdBook = bookService.createBook(bookCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }
}
