package com.exadel.sandbox.httpmapstruct.mapper;

import com.exadel.sandbox.httpmapstruct.controller.dto.BookDto;
import com.exadel.sandbox.httpmapstruct.model.Book;
import java.util.List;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "id", defaultExpression = "java(java.util.UUID.randomUUID().toString())")
    @Mapping(target = "author", source = "writer")
    @Mapping(target = "version", ignore = true)
    Book toBook(BookDto bookDto);

    @Mapping(target = "writer", source = "author")
    BookDto toBookDto(Book book);

    List<BookDto> toBookDtoList(List<Book> book);

    @Mapping( target = "id", ignore = true )
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void patchBook(Book book, @MappingTarget Book bookToPatch);
}
