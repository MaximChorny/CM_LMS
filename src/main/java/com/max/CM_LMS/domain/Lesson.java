package com.max.CM_LMS.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Lesson {
    protected Integer id = null;
    protected String topic;
    protected LocalDate date;
    protected String materials;

    protected ArrayList<HomeTask> homeTasks;

    public Lesson(String topic, LocalDate date, String materials, HomeTask homeTasks) {
        this.topic = topic;
        this.date = date;
        this.materials = materials;
        addHomeTask(homeTasks);
    }
    public Lesson(String topic, LocalDate date, String materials) {
        this.topic = topic;
        this.date = date;
        this.materials = materials;
    }
    public Lesson(String topic, LocalDate date) {
        this.topic = topic;
        this.date = date;
    }
    public Lesson() {
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

    public ArrayList<HomeTask> getHomeTasks() {
        return homeTasks;
    }

    public void setHomeTasks(ArrayList<HomeTask> homeTasks) {
        this.homeTasks = homeTasks;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean addHomeTask(HomeTask homework) {
        if (homeTasks == null) {
            homeTasks = new ArrayList<>();
        }
       return homeTasks.add(homework);
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "topic='" + topic + '\'' +
                ", date=" + date +
                ", materials='" + materials + '\'' +
                ", homeTasks=" + homeTasks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return Objects.equals(id, lesson.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
