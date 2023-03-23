package com.controller;

import com.model.StudentDetails;
import com.model.UserAndBook;
import com.service.StudentDetailsService;
import com.service.UserAndBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;

@RestController

@CrossOrigin(origins = "http://127.0.0.1:5500", allowedHeaders = "*", allowCredentials = "true")
@RequestMapping(value = "/userandbook")
public class UserAndBookController {
    @Autowired
    UserAndBookService userAndBookService;
    private static final Logger logger = LoggerFactory.getLogger(UserAndBookController.class);

    @GetMapping
    public List<UserAndBook> getUserAndBookDetails() {
        logger.info("User and book List");
        return userAndBookService.getUserAndBookDetails();
    }

    @GetMapping("totaldues")
    public BigDecimal gettotaldues() {
        logger.info("Student List");
        return userAndBookService.totaldues();
    }

}
