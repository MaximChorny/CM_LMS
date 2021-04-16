package com.max.CM_LMS.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Student extends User {

    private Group group;
    private List<HomeWork> homeWorks;

    public Student(String firstName, String lastName, LocalDate dateofBirth, Group group) {
        super(firstName, lastName, dateofBirth);
        this.group = group;
    }

    public Student(String firstName, String lastName, LocalDate dateofBirth) {
        super(firstName, lastName, dateofBirth);
    }


    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<HomeWork> getHomeWorks() {
        return homeWorks;
    }

    public boolean addHomework(HomeWork homeWork) {
        if (homeWorks == null) {
            homeWorks = new ArrayList<>();
        }
        return homeWorks.add(homeWork);
    }
    @Override
    public String toString() {
        return "Student{" + "Id=" + super.getId() +
                " , group=" + group.getName() +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateofBirth=" + dateofBirth +
                "} ";
    }


}
