package com.jpats.jpats.dao;

import com.jpats.jpats.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface BookDao extends JpaRepository<Book,Integer> {
    
    List<Book> findAll();
    List<Book> getBookByAuthorStartingWith(String author);
    //List<Book> getBookByPriceGreaterThan(Float price);
    
/*    @Query(value = "select * from sys_book where id=(select max(id) from sys_book)",nativeQuery = true)
    Book getMaxIdBook();
    
    @Query("select b from sys_book where b.author=:author and b.id=:id")
    List<Book> getBookByAuthorAndId(@Param("author") String author,@Param("id") Integer id);
    
    @Query("select b from sys_book where b.id=?1 and b.name=?2")
    List<Book> getBookByIdAndName(Integer id,String name);*/
    
}
