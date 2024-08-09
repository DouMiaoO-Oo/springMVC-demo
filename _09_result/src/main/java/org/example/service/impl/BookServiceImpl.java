package org.example.service.impl;

import org.example.dao.BookDao;
import org.example.service.BookService;
import org.example.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.lang.Boolean.TRUE;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Override
    public Boolean saveBook(Book book) {
        bookDao.saveBook(book);
        return TRUE;
    }

    @Override
    public Boolean deleteBook(Integer id) {
        bookDao.deleteBook(id);
        return TRUE;
    }

    @Override
    public Boolean updateBook(Book book) {
        bookDao.updateBook(book);
        return TRUE;
    }

    @Override
    public Book getById(Integer id) {
        return bookDao.getById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.getAll();
    }
}
