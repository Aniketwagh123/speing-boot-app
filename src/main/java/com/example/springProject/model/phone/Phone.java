package com.example.springProject.model.phone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rowsNo;
    private String phoneNumber;

    @Override
    public String toString() {
        return "Phone{" +
                "rowsNo=" + rowsNo +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public void setRowsNo(int rowsNo) {
        this.rowsNo = rowsNo;
    }


    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getRowsNo() {
        return rowsNo;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }
}
