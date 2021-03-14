package com.max.CM_LMS.domain;



public class HomeWork {

    Student student;
    HomeTask homeTask;
    String whatStudentDid;

    int mark;

    public HomeWork(Student student, HomeTask homeTask, String whatStudentDid) {
        this.student = student;
        this.homeTask = homeTask;
        this.whatStudentDid = whatStudentDid;
    }

    public String getWhatStudentDid() {
        return whatStudentDid;
    }

    public void setWhatStudentDid(String whatStudentDid) {
        this.whatStudentDid = whatStudentDid;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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
