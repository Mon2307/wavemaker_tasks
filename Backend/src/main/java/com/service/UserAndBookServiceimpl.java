package com.service;

import com.model.BookDetails;
import com.model.BookIssue;
import com.model.UserAndBook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserAndBookServiceimpl implements UserAndBookService{

    @Autowired
    private SessionFactory sessionFactory;


    private BookIssue bookIssue;

     public BookissueService bookissueService;


    public UserAndBook create(BookIssue bookIssue) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        UserAndBook userAndBook = new UserAndBook();

        int bookId = bookissueService.returnBookId(bookIssue.getBookName());
        int userId= bookissueService.returnStudentId(bookIssue.getStudentRollNo());
        System.out.println(bookId);
        System.out.println(userId);
        userAndBook.setBookId(bookId);
        userAndBook.setStudentId(userId);
        userAndBook.setIssueDate(bookIssue.getIssueDate());
//       session.save(userAndBook);
        transaction.commit();
        session.close();
        System.out.println(userAndBook);
        return userAndBook;
    }



    public List<UserAndBook> getUserAndBookDetails() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<UserAndBook> userAndBookList = session.createQuery("from UserAndBook", UserAndBook.class).list();
        transaction.commit();
        session.close();
        return userAndBookList;
    }

    public void insertUserId(int id) {

    }

    public void insertBookId(int id) {

    }

    public boolean isBookAvailable(boolean x) {
        return false;
    }



}
