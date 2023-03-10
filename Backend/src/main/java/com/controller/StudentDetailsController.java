package com.controller;

import com.model.StudentDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import com.service.StudentDetailsService;

@RestController

@CrossOrigin(origins = "http://127.0.0.1:5500", allowedHeaders = "*", allowCredentials = "true")
@RequestMapping(value = "/students")
public class StudentDetailsController {

    @Autowired
    StudentDetailsService studentDetailsService;
    private static final Logger logger = LoggerFactory.getLogger(StudentDetailsController.class);

    @GetMapping
    public List<StudentDetails> getBookDetails() {
        logger.info("Student List");
        return studentDetailsService.getStudentDetails();
    }

    @PostMapping("/insert")
    public StudentDetails create(@RequestBody StudentDetails studentDetails) {
        logger.info("create Student is invoked{}", studentDetails);
        return studentDetailsService.create(studentDetails);
    }

}
