package com.controller;

import com.model.BookDetails;
import com.model.BookIssue;
import com.model.LibrarianDetails;
import com.model.UserAndBook;
import com.service.BookissueService;
import com.service.UserAndBookService;
import com.service.UserAndBookServiceimpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@CrossOrigin(origins = "http://127.0.0.1:5500", allowedHeaders = "*", allowCredentials = "true")
@RequestMapping(value = "/bookissue")
public class BookissueController {
    @Autowired
    BookissueService bookissueService;

    @Autowired
    UserAndBookService userAndBookService;
    private static final Logger logger = LoggerFactory.getLogger(BookissueController.class);

    @GetMapping("/{bookName}")
    public int returnBookId(@PathVariable("bookName") String bookName){
        //logger.info("getEmployeeById is invoked with Employee Id : {}",id);
        return bookissueService.returnBookId(bookName);
    }


    @PostMapping("/insert")
    public UserAndBook create(@RequestBody BookIssue bookIssue) {
        logger.info("create Book is invoked{}",bookissueService);
        return userAndBookService.create(bookIssue);
    }

}
