package com.services;

import com.model.BookAndUser;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookAndUserimpl implements BookAndUserService{

    @Autowired
    private SessionFactory sessionfactory;
    public List<BookAndUser> getBookAndUserDetails() {
        Session session = sessionfactory.openSession();
        Transaction transaction= session.beginTransaction();
        List<BookAndUser> bookAndUsersList= session.createQuery("from BookAndUser",BookAndUser.class).list();
        transaction.commit();
        session.close();
        return bookAndUsersList;
    }

   /* public BookAndUser getBookAndUserId(int id) {
        return null;
    }*/

    public BookAndUser create(BookAndUser bookAndUser) {
        Session session =sessionfactory.openSession();
        Transaction transaction= session.beginTransaction();
        session.save(bookAndUser);
        transaction.commit();
        session.close();
        return bookAndUser;
    }

    public BookAndUser getBookAndUserById(int id) {
        Session session = sessionfactory.openSession();
        Transaction transaction = session.beginTransaction();
        BookAndUser bookAndUser = session.get(BookAndUser.class,id);
        transaction.commit();
        session.close();
        return bookAndUser;
    }

    public BookAndUser updateBookAndUser(BookAndUser bookAndUser) {

        Session session= sessionfactory.openSession();
        Transaction transaction= session.beginTransaction();
        session.saveOrUpdate(bookAndUser);
        transaction.commit();
        session.close();

        return bookAndUser;
    }

    public BookAndUser deleteBookAndUserById(int id) {
        Session session=sessionfactory.openSession();
        Transaction transaction= session.beginTransaction();
        BookAndUser bookAndUser=session.get(BookAndUser.class,id);
        session.delete(bookAndUser);
        transaction.commit();
        session.close();
        return bookAndUser;
    }
}
