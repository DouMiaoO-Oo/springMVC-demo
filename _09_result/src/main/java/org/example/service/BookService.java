package org.example.service;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.domain.Book;

import java.util.List;

public interface BookService {
    Boolean saveBook(Book book);

    Boolean deleteBook(Integer id);

    Boolean updateBook(Book book);

    Book getById(Integer id);

    List<Book> getAll();
}
