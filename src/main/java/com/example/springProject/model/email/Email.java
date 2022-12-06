package com.example.springProject.model.email;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rowsNo;
    private String emailId;

    @Override
    public String toString() {
        return "Email{" +
                "rowsNo=" + rowsNo +
                ", emailId='" + emailId + '\'' +
                '}';
    }

    public void setRowsNo(int rowsNo) {
        this.rowsNo = rowsNo;
    }


    public String getEmailId() {
        return emailId;
    }

    public int getRowsNo() {
        return rowsNo;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

}
