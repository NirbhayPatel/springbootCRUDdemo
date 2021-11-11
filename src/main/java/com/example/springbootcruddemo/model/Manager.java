package com.example.springbootcruddemo.model;

import javax.persistence.*;

@Entity
@Table(name = "manager")
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long mrgId;

    @Column(name = "mrgName")
    private String mrgName;

    @Column(name = "employeeId")
    private long employeeId;

    public Manager(String mrgName) {
        super();
        this.mrgName = mrgName;
    }

    public Manager() {

    }

    public long getMrgId() {
        return mrgId;
    }

    public void setMrgId(long mrgId) {
        this.mrgId = mrgId;
    }

    public String getMrgName() {
        return mrgName;
    }

    public void setMrgName(String mrgName) {
        this.mrgName = mrgName;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }
}
