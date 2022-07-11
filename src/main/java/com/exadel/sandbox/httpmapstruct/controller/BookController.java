package com.exadel.sandbox.httpmapstruct.controller;

import com.exadel.sandbox.httpmapstruct.controller.dto.BookDto;
import com.exadel.sandbox.httpmapstruct.controller.dto.BookIdDto;
import com.exadel.sandbox.httpmapstruct.mapper.BookMapper;
import com.exadel.sandbox.httpmapstruct.service.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final BookMapper bookMapper;

    @GetMapping
    public List<BookDto> getList(@RequestParam(required = false) String writer) {
        return bookMapper.toBookDtoList(bookService.getList(writer));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookIdDto post(@RequestBody BookDto bookDto) {
        return new BookIdDto(bookService.addBook(bookMapper.toBook(bookDto)));
    }

    @GetMapping("/{id}")
    public BookDto get(@PathVariable String id) {
        return bookMapper.toBookDto(bookService.get(id));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void put(@PathVariable String id, @RequestBody BookDto bookDto) {
        bookService.update(id, bookMapper.toBook(bookDto));
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void patch(@PathVariable String id, @RequestBody BookDto bookDto) {
        bookService.patch(id, bookMapper.toBook(bookDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        bookService.delete(id);
    }

}
