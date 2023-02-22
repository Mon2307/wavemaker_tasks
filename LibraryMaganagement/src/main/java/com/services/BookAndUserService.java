package com.services;

import com.model.BookAndUser;
import com.model.BookDetails;

import java.util.List;

public interface BookAndUserService {


    List<BookAndUser> getBookAndUserDetails();

   /* BookAndUser getBookAndUserId(int id);*/

    BookAndUser create(BookAndUser bookAndUser);

   BookAndUser getBookAndUserById(int id);

    BookAndUser updateBookAndUser(BookAndUser bookAndUser);

    BookAndUser deleteBookAndUserById(int id);
}
