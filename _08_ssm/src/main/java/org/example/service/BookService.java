package org.example.service;

import org.example.dao.BookDao;
import org.example.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;

    public void save(Book book){
        bookDao.save(book);
    }

    public void update(Book book){
        bookDao.update(book);
    }


    public void deleteById(Integer id){
        bookDao.delete(id);
    }

    public Book getBookById(Integer id){
        return bookDao.getBookById(id);
    }
    public List<Book> getAll(){
        return bookDao.getAll();
    }
}
