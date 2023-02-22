package com.services;

import com.model.UserDetails;

import java.util.List;

public interface UserDetailsService {

    List<UserDetails> getUserDetails();

    UserDetails insertUser(UserDetails userDetails);


    UserDetails getUserById(int id);

    UserDetails updateUser(UserDetails userDetails);


    UserDetails deleteUserById(int id);

}
