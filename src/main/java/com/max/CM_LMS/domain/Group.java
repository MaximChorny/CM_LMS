package com.max.CM_LMS.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Group {
    private Integer id;
    private String name;
    private String direction;
    private LocalDate startDate;

    private Set<Teacher> teachers;
    private Set<Student> students;
    private Feed feed;
    private ArrayList<Lesson> lessons;

    public void addLeson(Lesson lesson) {
        if (this.lessons == null) {
            this.lessons = new ArrayList<>();
        }
        this.lessons.add(lesson);
    }

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

    public void addLesson(Lesson lesson) {
        if (this.lessons == null) {
            this.lessons = new ArrayList<>();
        }
        this.lessons.add(lesson);
    }

    public void addTeacher(Teacher teacher) {
        if (this.teachers == null) {
            this.teachers = new HashSet<>();
        }
        this.teachers.add(teacher);
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

    @Override
    public String toString() {
        return "Group{" +
                " name='" + name + '\'' +
                ", direction='" + direction + '\'' +
                ", startDate=" + startDate +
                ", teachers=" + teachers +
                ", students=" + students +
                ", feed=" + feed +
                ", lessons=" + lessons +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return name.equals(group.name) &&
                direction.equals(group.direction) &&
                startDate.equals(group.startDate) &&
                teachers.equals(group.teachers) &&
                students.equals(group.students) &&
                feed.equals(group.feed) &&
                lessons.equals(group.lessons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, direction, startDate, teachers, students, feed, lessons);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
