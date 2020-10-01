package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Book;

public interface BookService {
    Page<Book> getAllBook(Pageable pageable);

    Book findById(int id);

    void save(Book book);
}
