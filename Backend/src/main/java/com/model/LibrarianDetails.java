package com.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name="librarian")
public class LibrarianDetails {

    @Id
    @Column(name ="id")
    private int librarianId;

    @Column(name ="emailid")
    private String emailId;



    @Column(name ="loginpassword")
    private String password;

    @Column(name ="name")
    private String librarianName;

    @Column(name ="qualification")
    private String qualification;

     @Column(name="joining_date")
    private Date joiningDate;

     @Column(name = "genderid")
    private int genderId;

    public int getLibrarianId() {
        return librarianId;
    }

    public void setLibrarianId(int librarianId) {
        this.librarianId = librarianId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }




    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLibrarianName() {
        return librarianName;
    }

    public void setLibrarianName(String librarianName) {
        this.librarianName = librarianName;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public int getGenderId() {
        return genderId;
    }

    public void setGenderId(int genderId) {
        this.genderId = genderId;
    }

    @Override
    public String toString() {
        return "LibrarianDetails{" +
                "librarianId=" + librarianId +
                ", emailId='" + emailId + '\'' +
                ", password='" + password + '\'' +
                ", librarianName='" + librarianName + '\'' +
                ", qualification='" + qualification + '\'' +
                ", joiningDate=" + joiningDate +
                ", genderId=" + genderId +
                '}';
    }
}
