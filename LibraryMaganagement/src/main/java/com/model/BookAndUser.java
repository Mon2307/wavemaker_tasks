package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="bookanduser")
public class BookAndUser {

    @Id
    @Column(name ="id")
    private int Id;
    @Column(name="userid")
    private int userId;

    @Column(name="bookid")
    private int bookId;
    @Column(name="issuedate")
    private String issued_On;
    @Column(name="returndate")
    private String returned_On;

    @Column(name="renew")
    private String renewed_On;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getIssued_On() {
        return issued_On;
    }

    public void setIssued_On(String issued_On) {
        this.issued_On = issued_On;
    }

    public String getReturned_On() {
        return returned_On;
    }

    public void setReturned_On(String returned_On) {
        this.returned_On = returned_On;
    }

    public String getRenewed_On() {
        return renewed_On;
    }

    public void setRenewed_On(String renewed_On) {
        this.renewed_On = renewed_On;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}


