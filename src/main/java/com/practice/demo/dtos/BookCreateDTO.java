package com.practice.demo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record BookCreateDTO(
        @NotBlank(message = "Title is required")
        @Size(min = 1, max = 100, message = "Title must be between 1 and 100 characters")
        String title,

        @NotBlank(message = "Author is required")
        @Size(min = 1, max = 50, message = "Author must be between 1 and 50 characters")
        String author
) {}
