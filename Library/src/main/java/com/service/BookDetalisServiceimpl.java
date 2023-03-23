package com.service;

import com.model.BookDetails;
import com.model.UserAndBook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
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
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String s="select * from book_detail where id =:id";
        NativeQuery<BookDetails> nativeQuery=session.createNativeQuery(s,BookDetails.class);
        nativeQuery.setParameter("id",id);
        BookDetails book = nativeQuery.getSingleResult();
        transaction.commit();
        session.close();
        return book;
    }

//    public BookDetails showIssuedBook() {
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        String s="select * from book_details where id =:id";
//        NativeQuery<BookDetails> nativeQuery=session.createNativeQuery(s,BookDetails.class);
//        nativeQuery.setParameter("id",id);
//        BookDetails book = nativeQuery.getSingleResult();
//        transaction.commit();
//        session.close();
//        return book;
//    }

    public Boolean deleteBookById(int id) {
        return null;
    }

    @Override
    public BigInteger totalbooks() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String s=" SELECT COUNT(id) FROM book_detail";
        NativeQuery<BigInteger> nativeQuery=session.createNativeQuery(s);
//        Query query = session.createQuery(s, UserAndBook.class).setParameter("userid", userId ).setParameter("bookid",bookId);
        BigInteger totalBooks = nativeQuery.getSingleResult();
        return totalBooks;
    }
}
