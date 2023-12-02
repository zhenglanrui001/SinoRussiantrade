package com.haikang.entity;

public class Student {
    private int id;
    private String sName;
    private String sNo;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsNo() {
        return sNo;
    }

    public void setsNo(String sNo) {
        this.sNo = sNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", sName='" + sName + '\'' +
                ", sNo='" + sNo + '\'' +
                ", age=" + age +
                '}';
    }
}
