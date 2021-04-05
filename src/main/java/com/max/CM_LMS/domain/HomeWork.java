package com.max.CM_LMS.domain;


import java.time.LocalDate;

public class HomeWork {
    Integer id = 0;
    Student author;
    HomeTask homeTask;
    String whatStudentDid;
    LocalDate dateSubmitted;
    int mark;

    public HomeWork()
    {

    }
    public HomeWork(Student student, HomeTask homeTask, String whatStudentDid) {
        this.author = student;
        this.homeTask = homeTask;
        this.whatStudentDid = whatStudentDid;
    }

    public HomeWork(Student student, HomeTask homeTask, String whatStudentDid, LocalDate date) {
        this.author = student;
        this.homeTask = homeTask;
        this.whatStudentDid = whatStudentDid;
        this.dateSubmitted =date;
    }

    public LocalDate getDateSubmitted() {
        return dateSubmitted;
    }

    public void setDateSubmitted(LocalDate dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    public String getWhatStudentDid() {
        return whatStudentDid;
    }

    public void setWhatStudentDid(String whatStudentDid) {
        this.whatStudentDid = whatStudentDid;
    }

    public Student getAuthor() {
        return author;
    }

    public void setAuthor(Student author) {
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public HomeTask getHomeTask() {
        return homeTask;
    }

    public void setHomeTask(HomeTask homeTask) {
        this.homeTask = homeTask;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
