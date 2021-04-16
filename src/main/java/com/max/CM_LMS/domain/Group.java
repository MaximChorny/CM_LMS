package com.max.CM_LMS.domain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.*;

public class Group {

    private static final Logger logger = LogManager.getLogger(Group.class);

    private Integer id = null;
    private String name;
    private String direction;
    private LocalDate startDate;

    private Set<Teacher> teachers;
    private Set<Student> students;
    private Feed feed;
    private ArrayList<Lesson> lessons;


    public Group(String name, String direction, LocalDate startDate) {
        this.name = name;
        this.direction = direction;
        this.startDate = startDate;
    }

    public Group(String name, String direction, LocalDate startDate, Set<Student> students) {
        this.name = name;
        this.direction = direction;
        this.startDate = startDate;
        this.students = students;
    }

    public Group(String name, String direction, LocalDate startDate, Set<Teacher> teachers, Set<Student> students, Feed feed, ArrayList<Lesson> lessons) {
        this.name = name;
        this.direction = direction;
        this.startDate = startDate;
        this.teachers = teachers;
        this.students = students;
        this.feed = feed;
        this.lessons = lessons;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(ArrayList<Lesson> lessons) {
        this.lessons = lessons;
    }

    public String getName() {
        return name;
    }

    public String getDirection() {
        return direction;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public boolean addTeacher(Teacher teacher) {
        if (this.teachers == null) {
            this.teachers = new HashSet<>();
        }
        return this.teachers.add(teacher);

    }

    public boolean addLeson(Lesson lesson) {
        //   logger.info( lesson.toString());
        if (this.lessons == null) {
            this.lessons = new ArrayList<>();
        }
        return this.lessons.add(lesson);
    }

    public boolean addStudent(Student student) {

        if (this.students == null) {
            this.students = new HashSet<>();
        }

        return this.students.add(student);

    }

    private String getAllTeachersNamesString() {
        StringBuilder result = new StringBuilder();

        Iterator<Teacher> iterator = teachers.iterator();
        while (iterator.hasNext()) {
            Teacher item = iterator.next();
            result.append(item.getFirstName()).append(" ").append(item.getLastName()).append(", ");
        }
        return result.substring(0, result.length() - 2);
    }

    private String getAllStudentsNamesString() {
        String res = "";
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student item = iterator.next();
            res += item.getFirstName() + " " + item.getLastName() + ", ";
        }
        return res.substring(0, res.lastIndexOf(','));
    }

    @Override
    public String toString() {
        return "Group{" +
                " name='" + name + '\'' +
                ", direction='" + direction + '\'' +
                ", startDate=" + startDate +
                ", teachers= " + getAllTeachersNamesString() +
                ", students= " + getAllStudentsNamesString() +
                ", feed=" + feed +
                ", lessons=" + lessons +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(id, group.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
