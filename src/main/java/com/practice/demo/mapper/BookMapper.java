package com.practice.demo.mapper;


import com.practice.demo.dtos.BookCreateDTO;
import com.practice.demo.dtos.BookDTO;
import com.practice.demo.entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDTO toDTO(Book book);

    List<BookDTO> toDTOList(List<Book> books);

    @Mapping(target = "isbn", ignore = true)
    Book toEntity(BookCreateDTO bookCreateDTO);

    Book toEntity(BookDTO bookDTO);

    @Mapping(target = "id", ignore = true)
    void updateBookFromDTO(BookDTO bookDTO, @MappingTarget Book book);
}
