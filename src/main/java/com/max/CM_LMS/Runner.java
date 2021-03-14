package com.max.CM_LMS;

import com.max.CM_LMS.domain.*;
import com.max.CM_LMS.domain.dao.GroupDao;
import com.max.CM_LMS.domain.dao.UserDao;
import com.max.CM_LMS.domain.dao.inMemory.inMemoryGroupDao;
import com.max.CM_LMS.domain.dao.inMemory.inMemoryUserDao;
import com.max.CM_LMS.domain.persistence.Persistence;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Runner {

    public static void main(String[] args) {

       /* Persistence persistence = Persistence.getInstance();
        Persistence persistence2 = Persistence.getInstance();
        System.out.println(persistence);*/

        Group javaElementary = new Group("Java Elementary","Java",LocalDate.ofYearDay(2020,1));

        Lesson one = new Lesson("Hello world!", LocalDate.ofYearDay(2020, 05), "metanit.com/java/tutorial/3.11.php");
        HomeTask hw1 = new HomeTask(one, LocalDate.ofYearDay(2020, 15));
        one.addHomeTask(hw1);

        Lesson two = new Lesson("Generic", LocalDate.ofYearDay(2020, 10), "metanit.com/java/tutorial/3.11.php");
        HomeTask hw2 = new HomeTask(two, LocalDate.ofYearDay(2020, 20));
        two.addHomeTask(hw2);

        Teacher first = new Teacher("Qwerty", "Sanches", LocalDate.ofYearDay(1978, 325), "mentor");
        first.addGroup(javaElementary);

        Student student1 = new Student("Morty", "Holl", LocalDate.ofYearDay(2006, 14), javaElementary);
        Student student2 = new Student("Nataha", "Rovnaya", LocalDate.ofYearDay(1996, 175), javaElementary);
        Student student3 = new Student("Boris", "Russki", LocalDate.ofYearDay(1980, 244), javaElementary);
        Student student4 = new Student("Pol", "Phayst", LocalDate.ofYearDay(2000, 200), javaElementary);
        Student student5 = new Student("Nicol", "Kidman", LocalDate.ofYearDay(1995, 98), javaElementary);

        student1.addHomework(new HomeWork(student1, hw1, "Hello, word"));
        student2.addHomework(new HomeWork(student2, hw1, "Hello, word!!"));
        student3.addHomework(new HomeWork(student3, hw1, "Hello  "));
        student4.addHomework(new HomeWork(student4, hw1, "Hello1111"));
        student5.addHomework(new HomeWork(student5, hw1, "Hello "));


        Post firstPost = new Post("Hello",LocalDate.ofYearDay(2020,1));
        Post secondPost = new Post("Welcome, to the club,boddy",  LocalDate.ofYearDay(2020, 05));

        Feed feed = new Feed(javaElementary);
        feed.addPost(firstPost);
        feed.addPost(secondPost);

        javaElementary.setFeed(feed);

        javaElementary.addLeson(one);
        javaElementary.addLeson(two);

        javaElementary.addTeacher(first);
        Set<Student> students = new HashSet<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        javaElementary.setStudents(students);
       System.out.println( javaElementary.toString());

      /*  Group gr1 = new Group("Begginer","Back-end",LocalDate.of(2009,12,13));
        Group gr2 = new Group("Mid","Back-end2",LocalDate.of(2019,1,15));
        Group gr3 = new Group("Senuior","application",LocalDate.of(2018,10,24));

        GroupDao exDao = new inMemoryGroupDao();

        exDao.saveGroup(gr1);
        exDao.saveGroup(gr2);
        exDao.saveGroup(gr3);

      //  Persistence.printAll(Persistence.getGroups());

        gr2.addTeacher(first);

        exDao.updateGroup(gr2);



       // Persistence.printAll(Persistence.getGroups());
        UserDao userDaoExample = new inMemoryUserDao();

        userDaoExample.saveUser(student1);
        userDaoExample.saveUser(student2);
        userDaoExample.saveUser(first);
        userDaoExample.saveUser(student3);

        Persistence.printAll(Persistence.getUsers());*/


    }
}
