package com.practice.demo.services;

import com.practice.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl {

    private final BookRepository bookRepository;


    @Autowired
    public BookServiceImpl (BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //Service methods using bookRepository

}
