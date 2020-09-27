package com.jpats.jpats.service;

import com.jpats.jpats.dao.BookDao;
import com.jpats.jpats.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookDao bookDao;
    
    public void addBook(Book bk){
        bookDao.save(bk);
    }

    public Page<Book> getBookByPage(Pageable pageable){
        return bookDao.findAll(pageable);
    }
    
    public List<Book> getBookByAuthorStartingWith(String author){
        return bookDao.getBookByAuthorStartingWith(author);
    }
    
    public List<Book> findAll(){
        return bookDao.findAll();
    }
    
}
