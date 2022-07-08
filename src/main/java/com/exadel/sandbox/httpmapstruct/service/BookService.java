package com.exadel.sandbox.httpmapstruct.service;

import com.exadel.sandbox.httpmapstruct.mapper.BookMapper;
import com.exadel.sandbox.httpmapstruct.model.Book;
import com.exadel.sandbox.httpmapstruct.repository.BookRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repository;
    private final BookMapper bookMapper;

    public List<Book> getList(String writer) {
        return repository.getList(writer);
    }

    public String addBook(Book book) {
        return repository.addBook(book);
    }

    public Book get(String id) {
        return repository.get(id);
    }

    public void update(String id, Book book) {
        book.setId(id);
        repository.update(book);
    }

    public void patch(String id, Book book) {
        Book bookToPatch = repository.get(id);
        bookMapper.patchBook(book, bookToPatch);
        repository.update(bookToPatch);
    }

    public void delete(String id) {
        repository.delete(id);
    }
}
