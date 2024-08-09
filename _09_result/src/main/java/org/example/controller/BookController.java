package org.example.controller;

import org.example.domain.Book;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.example.controller.Code.*;


@RestController  // @Controller + @ResponseBody
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @PostMapping
    public Result save(@RequestBody Book book){
        Boolean ret = bookService.saveBook(book);
        return new Result(SAVE_OK, ret);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") Integer id){
        Boolean ret = bookService.deleteBook(id);
        return new Result(DELETE_OK, ret);
    }

    @PutMapping
    public Result update(@RequestBody Book book){
        Boolean ret = bookService.updateBook(book);
        return new Result(UPDATE_OK, ret);
    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable("id") Integer id){
        Book book = bookService.getById(id);
        return new Result(GET_OK, book);
    }
    @GetMapping
    public Result getAll(){
        List<Book> books = bookService.getAll();
        return new Result(GET_OK, books);
    }
}
