package com.practice.demo.services;

import com.practice.demo.dtos.BookCreateDTO;
import com.practice.demo.dtos.BookDTO;
import com.practice.demo.entities.Book;
import com.practice.demo.mapper.BookMapper;
import com.practice.demo.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Autowired
    public List<BookDTO> findAll() {
        return bookMapper.toDTOList(bookRepository.findAll());
    }

    @Autowired
    public Optional<BookDTO> findByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn).map(bookMapper::toDTO);
    }

    @Autowired
    public BookDTO createBook(BookCreateDTO bookCreateDTO) {
        Book book = bookMapper.toEntity(bookCreateDTO);
        book.setIsbn(UUID.randomUUID().toString());
        Book savedBook = bookRepository.save(book);
        return bookMapper.toDTO(savedBook);
    }

    @Autowired
    public Optional<BookDTO> updateBook(BookDTO bookDTO) {
        return bookRepository.findByIsbn(bookDTO.isbn())
                .map(existingBook -> {
                    bookMapper.updateBookFromDTO(bookDTO, existingBook);
                    Book updatedBook = bookRepository.save(existingBook);
                    return bookMapper.toDTO(updatedBook);
                });
    }

    @Autowired
    public boolean deleteBook(String isbn) {
        return bookRepository.findByIsbn(isbn)
                .map(book -> {
                    bookRepository.delete(book);
                    return true;
                })
                .orElse(false);
    }


}
