package com.service;

import com.model.BookDetails;
import com.model.BookIssue;
import com.model.StudentDetails;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookissueService {

    @Autowired
    private SessionFactory sessionFactory;
    public List<BookIssue> getBookissueDetails(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<BookIssue> bookIssueList = session.createQuery("from BookIssue", BookIssue.class).list();
        transaction.commit();
        session.close();
        return bookIssueList;
    }

    public BookIssue create(BookIssue bookIssue) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(bookIssue);
        transaction.commit();
        session.close();
        return bookIssue;
    }

    public int returnBookId(String bookName) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from BookDetails where bookName =:book", BookDetails.class).setParameter("book",bookName);
        BookDetails bookDetails = (BookDetails) query.list().get(0);
        bookDetails.getBookId();
        transaction.commit();
        session.close();
        System.out.println(bookDetails.getBookId());
        return bookDetails.getBookId();
    }

    public int returnStudentId(String rollNo) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("from StudentDetails where  rollNo =:rollno", StudentDetails.class).setParameter("rollno",rollNo);
        StudentDetails studentDetails = (StudentDetails) query.list().get(0);
        studentDetails.getStudentId();
        transaction.commit();
//
        session.close();
        return studentDetails.getStudentId();

        //        String s= "SELECT id FROM user_details  WHERE rollno = :rollNo";
//        SQLQuery query = session.createSQLQuery(s);
//        query.addEntity(StudentDetails.class);
//        query.setParameter("rollNo",rollNo);
//        userId=  Integer.parseInt((String) query.uniqueResult());
//        transaction.commit();
    }
}
