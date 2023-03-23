package com.service;

import com.model.StudentDetails;
import com.model.UserAndBook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
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



    public Boolean studentExists(String rollno){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Boolean exists=false;
        Query query = session.createQuery("from StudentDetails where  rollNo =:rollno", StudentDetails.class).setParameter("rollno",rollno);
        StudentDetails studentDetails = (StudentDetails) query.uniqueResult();
        if(studentDetails!=null){
            exists=true;
        }
        transaction.commit();
//
        session.close();
        return exists;
    }

    @Override
    public BigInteger totalstudents() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String s=" SELECT COUNT(rollno) FROM user_detail";
        NativeQuery<BigInteger> nativeQuery=session.createNativeQuery(s);
//        Query query = session.createQuery(s, UserAndBook.class).setParameter("userid", userId ).setParameter("bookid",bookId);
        BigInteger totalStudents = nativeQuery.getSingleResult();
        return totalStudents;
    }

    public StudentDetails updateStudent(StudentDetails studentDetails){
        Session session= sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(studentDetails);
        transaction.commit();
        session.close();
        return studentDetails;
    }
}
