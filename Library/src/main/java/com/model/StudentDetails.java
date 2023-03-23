package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Year;

@Entity
@Table(name="user_detail")
public class StudentDetails {

    @Id
    @Column(name ="id")
    private int studentId;

    @Column(name="rollno")
    private String rollNo;

    @Column(name="mailid")
    private String mailId;


    @Column(name="branch_id")
    private int branchId;

    @Column(name="gender_id")
    private int genderId;

    @Column(name="name")
    private String studentName;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }



    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public int getGenderId() {
        return genderId;
    }

    public void setGenderId(int genderId) {
        this.genderId = genderId;
    }

    @Override
    public String toString() {
        return "StudentDetails{" +
                "studentId=" + studentId +
                ", rollNo='" + rollNo + '\'' +
                ", mailId='" + mailId + '\'' +
                ", branchId=" + branchId +
                ", genderId=" + genderId +
                '}';
    }
}
