package com.max.CM_LMS.domain.service;

import com.max.CM_LMS.domain.HomeTask;
import com.max.CM_LMS.domain.Lesson;
import com.max.CM_LMS.domain.service.interfaces.HomeTaskService;

import java.time.LocalDate;

public class HomeTaskIm implements HomeTaskService {

    @Override
    public boolean createHomeTask(Lesson lesson, String task) {
        return lesson.addHomeTask(new HomeTask(task, LocalDate.now(), LocalDate.now().plusDays(7)));
    }

    @Override
    public void addHomeTask(Lesson lesson, String task) {
        lesson.addHomeTask(new HomeTask(task, LocalDate.now(), LocalDate.now().plusDays(7)));
    }

    @Override
    public boolean changeDeadLine(HomeTask homeTask, LocalDate date) {
        return homeTask.setDate(date);
    }
}
