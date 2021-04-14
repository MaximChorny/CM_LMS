package com.max.CM_LMS.domain;

import java.time.LocalDate;
import java.util.Objects;

public class HomeTask {

    private Integer id = null;
    private String task;
    private LocalDate date;
    private LocalDate deadLine;
    private Lesson lesson;

    public HomeTask() {
    }

    public HomeTask(Lesson lesson, LocalDate deadLine) {
        this.task = lesson.getTopic();
        this.date = lesson.getDate();
        this.deadLine = deadLine;
    }

    public HomeTask(String task, LocalDate date, LocalDate deadLine) {
        this.task = task;
        this.date = date;
        this.deadLine = deadLine;
    }

    public String getTask() {
        return task;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public boolean setDate(LocalDate date) {
        this.date = date;
        return true;
    }

    public void setHomeTask(String task, LocalDate date, String materials, LocalDate deadLine) {
        this.task = task;
        this.date = date;
        this.deadLine = deadLine;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
    }

    @Override
    public String toString() {
        return "HomeTask{" +
                "task='" + task + '\'' +
                ", date=" + date +
                ", deadLine=" + deadLine +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomeTask homeTask = (HomeTask) o;
        return Objects.equals(id, homeTask.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
