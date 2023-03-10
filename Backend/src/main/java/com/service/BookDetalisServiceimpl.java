package com.service;

import com.model.BookDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookDetalisServiceimpl implements BookDetailsService{

    @Autowired
    private SessionFactory sessionFactory;
    public String getBookByName() {
        return null;
    }

    public List<BookDetails> getBookDetails() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<BookDetails> bookList = session.createQuery("from BookDetails", BookDetails.class).list();
        transaction.commit();
        session.close();
        return bookList;
    }

    public BookDetails create(BookDetails bookDetails) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(bookDetails);
        transaction.commit();
        session.close();
        return bookDetails;
    }

    public BookDetails getBookById(int id) {
        return null;
    }

    public Boolean deleteBookById(int id) {
        return null;
    }
}
