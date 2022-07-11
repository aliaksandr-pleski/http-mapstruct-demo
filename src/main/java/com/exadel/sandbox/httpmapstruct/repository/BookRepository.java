package com.exadel.sandbox.httpmapstruct.repository;

import com.exadel.sandbox.httpmapstruct.model.Book;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    private final Map<String, Book> db = new HashMap<>();

    public String create(Book book) {
        String id = book.getId();
        db.put(id, book);

        return id;
    }

    public Book get(String id) {
        return db.get(id);
    }

    public List<Book> getList(String writer) {
        if (writer == null) {
            return db.values().stream().toList();
        }
        return db.values().stream()
            .filter(e -> writer.equals(e.getAuthor()))
            .collect(Collectors.toList());
    }

    public void update(Book book) {
        String id = book.getId();
        Book oldBook = db.get(id);
        book.setVersion(oldBook.getVersion() + 1);
        db.put(id, book);
    }

    public void delete(String id) {
        db.remove(id);
    }
}
