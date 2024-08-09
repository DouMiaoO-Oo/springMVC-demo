package org.example.controller;

import org.example.domain.Book;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // @Controller + @ResponseBody
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @PostMapping
    public boolean saveBook(@RequestBody Book book){
        bookService.save(book);
        return true;
    }
    @DeleteMapping("/{id}")
    public boolean deleteBook(@PathVariable("id") Integer id){
        bookService.deleteById(id);
        return true;
    }
    @PutMapping
    public boolean updateBook(@RequestBody Book book){
        bookService.update(book);
        return true;
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") Integer id){
        return bookService.getBookById(id);
    }

    @GetMapping
    public List<Book> getAll(){
        return bookService.getAll();
    }
}
