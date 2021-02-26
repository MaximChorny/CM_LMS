package com.max.CM_LMS.domain;

import java.time.LocalDate;
import java.util.ArrayList;

public class Lesson {
    protected String topic;
    protected LocalDate date;
    protected String materials;

    protected ArrayList<HomeworkTask> homeworkTasks;

    public Lesson(String topic, LocalDate date, String materials, HomeworkTask homeworkTasks) {
        this.topic = topic;
        this.date = date;
        this.materials = materials;
      giveHomework(homeworkTasks);
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public ArrayList<HomeworkTask> getHomeworkTasks() {
        return homeworkTasks;
    }

    public void setHomeworkTasks(ArrayList<HomeworkTask> homeworkTasks) {
        this.homeworkTasks = homeworkTasks;
    }

    public void giveHomework(HomeworkTask homework) {
        if (homeworkTasks == null) {
            homeworkTasks = new ArrayList<>();
        }
        homeworkTasks.add(homework);
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "topic='" + topic + '\'' +
                ", date=" + date +
                ", materials='" + materials + '\'' +
                ", homeworkTasks=" + homeworkTasks +
                '}';
    }
}
