package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="book_details")
public class BookDetails {

    @Id
    @Column(name ="book_id")
    private int bookId;
    @Column(name="book_name")
    private String empName;

    @Column(name="author_name")
    private String authorName;
    @Column(name="lang")
    private String language;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "BookDetails{" +
                "bookId=" + bookId +
                ", empName='" + empName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}

