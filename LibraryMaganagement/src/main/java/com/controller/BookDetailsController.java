package com.controller;

import com.model.BookDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import com.services.BookDetailsService;

@RestController
@RequestMapping("/books")


public class BookDetailsController {


    @Autowired
    BookDetailsService bookDetailsService;


    private static final Logger logger = LoggerFactory.getLogger(BookDetailsController.class);

    @GetMapping
    public List<BookDetails> getBookDetails() {
        logger.info("Book List");
        return bookDetailsService.getBookDetails();
    }

    @PostMapping("/insert")
    public BookDetails createBook(@RequestBody BookDetails bookDetails) {
        logger.info("create Book is invoked{}", bookDetails);
        return bookDetailsService.create(bookDetails);
    }

    @GetMapping("/{id}")
    public BookDetails getBookById(@PathVariable("id") int id) {
        logger.info("getBookById is invoked with Book Id : {}", id);
        return bookDetailsService.getBookById(id);
    }

    @PutMapping("/update")
    public BookDetails updateBook(@RequestBody BookDetails bookDetails) {
        return bookDetailsService.updateBook(bookDetails);
    }

    @DeleteMapping("/{id}")
    public BookDetails deleteBookById(@PathVariable("id") int id) {
        return bookDetailsService.deleteBookById(id);
    }
}


