package com.segmentfault.spring.boot.lesson9.controller;

import com.segmentfault.spring.boot.lesson9.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 图书的控制器
 *
 * @author miaoo
 * @since 2018/10/24
 */
@RestController
public class BookController {

    @Autowired
    @Qualifier("bookRepository")
    private PagingAndSortingRepository<Book,String> bookRepository;

    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable String id){
        Book book = bookRepository.findOne(id);
        return book;
    }

    @PostMapping("/book/{id}")
    public Book publishBook(@PathVariable String id , @RequestBody Book book){
        book.setId(id);
        book.setPublishDate(new Date(System.currentTimeMillis()));
        bookRepository.save(book);
        return book;
    }


}
