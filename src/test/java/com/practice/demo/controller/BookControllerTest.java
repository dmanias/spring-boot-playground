package com.practice.demo.controller;

import com.practice.demo.controllers.BookController;
import com.practice.demo.dtos.BookDTO;
import com.practice.demo.services.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(BookController.class)
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BookService bookService;

    @Test
    void shouldReturnEmptyListWhenGet() throws Exception {
        //Arrange
        // No arrangement needed as we expect an empty list

        //Act
        mockMvc.perform(get("/api/v1/books"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));

        //Assert
        // No assertions needed as we expect an empty list
    }

    @Test
    void shouldReturnAListWhenGet() throws Exception {
        //Arrange
        List<BookDTO> bookDTOs = Arrays.asList(
                new BookDTO("1234567789", "Test Book 1", "Test Author 1"),
                new BookDTO("0987654321", "Test Book 2", "test Author 2")
        );
        when(bookService.findAll()).thenReturn(bookDTOs);

        //Act & Assert
        mockMvc.perform(get("/api/v1/books"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].isbn", is("1234567789")))
                .andExpect(jsonPath("$[0].title", is("Test Book 1")));


        //Assert
        // An assertion for the list of books
    }

}
