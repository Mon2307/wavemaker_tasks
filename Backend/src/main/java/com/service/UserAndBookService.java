package com.service;

import com.model.BookIssue;
import com.model.StudentDetails;
import com.model.UserAndBook;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserAndBookService {


     void insertUserId(int id);

     void insertBookId(int id);

     boolean isBookAvailable(boolean x);



     UserAndBook create(BookIssue bookIssue);


     List<UserAndBook> getUserAndBookDetails();

}
