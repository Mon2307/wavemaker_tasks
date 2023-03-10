package com.service;

import com.model.BookDetails;
import com.model.LibrarianDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LibrarianDetailsServiceimpl implements LibrarianDetailsService{

    @Autowired
    private SessionFactory sessionFactory;
    public List<LibrarianDetails> getLibrarianDetails() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<LibrarianDetails> librarianDetailsList = session.createQuery("from LibrarianDetails", LibrarianDetails.class).list();
        transaction.commit();
        session.close();
        return librarianDetailsList;
    }

    public LibrarianDetails create(LibrarianDetails librarianDetails) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(librarianDetails);
        transaction.commit();
        session.close();
        return librarianDetails;
    }
}
