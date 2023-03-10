package com.service;

import com.model.StudentDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentDetailsServiceimpl implements StudentDetailsService{
    @Autowired
    private SessionFactory sessionFactory;

    public String getStudentByName() {
        return null;
    }

    public List<StudentDetails> getStudentDetails() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<StudentDetails> studentDetailsList = session.createQuery("from StudentDetails", StudentDetails.class).list();
        transaction.commit();
        session.close();
        return studentDetailsList ;
    }

    public StudentDetails create(StudentDetails studentDetails) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(studentDetails);
        transaction.commit();
        session.close();
        return studentDetails;
    }

    public StudentDetails getStudentByRollno(int rollno) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        StudentDetails studentDetails = session.get( StudentDetails.class,rollno);
        transaction.commit();
        session.close();
        return studentDetails ;
    }

    public StudentDetails deleteBookByrollNo(int rollno) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        StudentDetails studentDetails=session.get(StudentDetails.class,rollno);
        session.delete(studentDetails);
        transaction.commit();
        session.close();
        return studentDetails;
    }
}
