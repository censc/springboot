package com.jpats.jpats.controller;

import com.jpats.jpats.entity.Book;
import com.jpats.jpats.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bk")
public class BookController {

    @Autowired
    BookService bookService;
    
    @GetMapping("/findAll")
    public Page<Book> findAll(){
        PageRequest pr = PageRequest.of(1,3);
    
        Page<Book> pg = bookService.getBookByPage(pr);
        
        return pg;
    }
    
    @GetMapping("/addBk")
    public void addBook(){
        
        Book e = new Book();
        e.setName("Spring5高级编程");
        e.setAuthor("xx大神");
        e.setPrice(90.01f);
        bookService.addBook(e);
        
    }
    
    @GetMapping("/getList")
    public List<Book> getList(){
        return bookService.findAll();
    }
    
}
