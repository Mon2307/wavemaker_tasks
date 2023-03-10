package com.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

//@Entity
//@Table(name="userandbook")

public class BookIssue {


    private int userAndBookId;


    private String studentRollNo;


    private String bookName;

    private Date issueDate;
    public int getUserAndBookId() {
        return userAndBookId;
    }

    public void setUserAndBookId(int userAndBookId) {
        this.userAndBookId = userAndBookId;
    }

    public String getStudentRollNo() {
        return studentRollNo;
    }

    public void setStudentRollNo(String studentRollNo) {
        this.studentRollNo = studentRollNo;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }
}
