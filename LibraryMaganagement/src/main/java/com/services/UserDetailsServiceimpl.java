package com.services;

import com.model.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceimpl implements UserDetailsService{

    @Autowired
    private SessionFactory sessionfactory;


    public List<UserDetails> getUserDetails() {
        Session session = sessionfactory.openSession();
        Transaction transaction= session.beginTransaction();
        List<UserDetails> userDetails= session.createQuery("from UserDetails",UserDetails.class).list();
        transaction.commit();
        session.close();
        return userDetails;

    }

    public UserDetails insertUser(UserDetails userDetails) {
        Session session =sessionfactory.openSession();
        Transaction transaction= session.beginTransaction();
        session.save(userDetails);
        transaction.commit();
        session.close();
        return userDetails;
    }

    public UserDetails getUserById(int id) {
        Session session = sessionfactory.openSession();
        Transaction transaction=session.beginTransaction();
        UserDetails userDetails = session.get(UserDetails.class,id);
        transaction.commit();
        session.close();
        return userDetails;
    }

    public UserDetails updateUser(UserDetails userDetails) {
        Session session= sessionfactory.openSession();
        Transaction transaction= session.beginTransaction();
        session.saveOrUpdate(userDetails);
        transaction.commit();
        session.close();

        return userDetails;
    }

    public UserDetails deleteUserById(int id) {

        Session session=sessionfactory.openSession();
        Transaction transaction= session.beginTransaction();
        UserDetails userDetails=session.get(UserDetails.class,id);
        session.delete(userDetails);
        transaction.commit();
        session.close();
        return userDetails;
    }
}
