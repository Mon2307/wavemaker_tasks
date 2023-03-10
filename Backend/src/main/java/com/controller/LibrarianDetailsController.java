package com.controller;

import com.model.BookDetails;
import com.model.LibrarianDetails;
import com.service.BookDetailsService;
import com.service.LibrarianDetailsService;
import com.service.LibrarianDetailsServiceimpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@CrossOrigin(origins = "http://127.0.0.1:5500", allowedHeaders = "*", allowCredentials = "true")
@RequestMapping(value = "/librarians")

public class LibrarianDetailsController {
    @Autowired
    LibrarianDetailsService librarianDetailsService;
    private static final Logger logger = LoggerFactory.getLogger(LibrarianDetailsController.class);

    @GetMapping
    public List<LibrarianDetails> getLibrarianDetails() {
        logger.info("Book List");
        return librarianDetailsService.getLibrarianDetails();
    }

    @PostMapping("/insert")
    public LibrarianDetails createBook(@RequestBody LibrarianDetails librarianDetails) {
        logger.info("create Book is invoked{}", librarianDetailsService);
        return librarianDetailsService.create(librarianDetails);
    }

}
