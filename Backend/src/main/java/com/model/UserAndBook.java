package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name="userandbook")
public class UserAndBook {

    @Id
    @Column(name ="id")
    private int userAndBookId;

    @Column(name ="user_id")
    private int studentId;

    @Column(name ="book_id")
    private int bookId;

    @Column(name="isbooklost")
    private boolean isBookLost;

    @Column(name="dues")
    private int dues;

    @Column(name = "issue_date")
    private Date issueDate;

    @Column(name = "return_date")
    private Date returnDate;

    @Column(name = "renew_date")
    private Date renewDate;

    public int getUserAndBookId() {
        return userAndBookId;
    }

    public void setUserAndBookId(int userAndBookId) {
        this.userAndBookId = userAndBookId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public boolean isBookLost() {
        return isBookLost;
    }

    public void setBookLost(boolean bookLost) {
        isBookLost = bookLost;
    }

    public int getDues() {
        return dues;
    }

    public void setDues(int dues) {
        this.dues = dues;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Date getRenewDate() {
        return renewDate;
    }

    public void setRenewDate(Date renewDate) {
        this.renewDate = renewDate;
    }

    @Override
    public String toString() {
        return "UserAndBook{" +
                "userAndBookId=" + userAndBookId +
                ", studentId=" + studentId +
                ", bookId=" + bookId +
                ", isBookLost=" + isBookLost +
                ", dues=" + dues +
                ", issueDate=" + issueDate +
                ", returnDate=" + returnDate +
                ", renewDate=" + renewDate +
                '}';
    }
}
