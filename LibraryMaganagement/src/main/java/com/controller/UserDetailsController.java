package com.controller;

import com.model.UserDetails;
import com.services.UserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
@RequestMapping("/users")
public class UserDetailsController {

    @Autowired
    UserDetailsService userDetailsService;

    private static final Logger logger = LoggerFactory.getLogger(UserDetailsController.class);

    @GetMapping
    public List<UserDetails> getUserDetails(){
        logger.info("Users List");
        return userDetailsService.getUserDetails();
    }

    @PostMapping("/insertUser")
    public UserDetails insertUser(@RequestBody UserDetails userDetails){
        logger.info("insert Book is invoked{}",userDetails);
        return userDetailsService.insertUser(userDetails);
    }

    @GetMapping("/id")
    public UserDetails getUserById(@PathVariable("id") int id){
        logger.info("getUserId is invoked with userId : {}",id);
        return userDetailsService.getUserById(id);
    }

    @PutMapping("/updateUser")
    public UserDetails updateUser(@RequestBody UserDetails userDetails){
        return userDetailsService.updateUser(userDetails);
    }

    @DeleteMapping("/{id}")
    public UserDetails deleteUser(@PathVariable("id") int id){
        return userDetailsService.deleteUserById(id);
    }
}


