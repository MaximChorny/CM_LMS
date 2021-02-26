package com.max.CM_LMS.domain;

import java.time.LocalDate;

public class HomeworkTask {

    private String task;
    private LocalDate date;
    private String materials;
    private LocalDate deadLine;

    private HomeworkTask() {
    }

    public HomeworkTask(String task, LocalDate date, String materials, LocalDate deadLine) {
        this.task = task;
        this.date = date;
        this.materials = materials;
        this.deadLine = deadLine;
    }

    public String getTask() {
        return task;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getMaterials() {
        return materials;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setHomework(String task, LocalDate date, String materials, LocalDate deadLine) {
        this.task = task;
        this.date = date;
        this.materials = materials;
        this.deadLine = deadLine;
    }

    @Override
    public String toString() {
        return "HomeworkTask{" +
                "task='" + task + '\'' +
                ", date=" + date +
                ", materials='" + materials + '\'' +
                ", deadLine=" + deadLine +
                '}';
    }
}
