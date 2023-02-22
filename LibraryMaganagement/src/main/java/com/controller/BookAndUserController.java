package com.controller;
import com.model.BookAndUser;
import com.model.BookDetails;
import com.services.BookDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import com.services.BookAndUserService;

@RestController
@RequestMapping("/booksandusers")
public class BookAndUserController {

    @Autowired
    BookAndUserService bookAndUserService;

    private static final Logger logger = LoggerFactory.getLogger(BookAndUserController.class);

    @GetMapping
    public List<BookAndUser> getBookAndUserDetails() {
        logger.info("BookAndUser List");
        return bookAndUserService.getBookAndUserDetails();
    }
    @PostMapping("/insert")
    public BookAndUser createBookAndUser(@RequestBody BookAndUser bookAndUser) {
        logger.info("create BookAndUser is invoked{}", bookAndUser);
        return bookAndUserService.create(bookAndUser);
    }

    @GetMapping("/{id}")
    public BookAndUser getBookAndUserById(@PathVariable("id") int id) {
        logger.info("getBookAndUserById is invoked with Book Id : {}", id);
        return bookAndUserService.getBookAndUserById(id);
    }

    @PutMapping("/update")
    public BookAndUser updateBookAndUser(@RequestBody BookAndUser bookAndUser) {
        return bookAndUserService.updateBookAndUser(bookAndUser);
    }

    @DeleteMapping("/{id}")
    public BookAndUser deleteBookAndUserById(@PathVariable("id") int id) {
        return bookAndUserService.deleteBookAndUserById(id);
    }

}

