package com.max.CM_LMS.domain.service.interfaces;

import com.max.CM_LMS.domain.HomeTask;
import com.max.CM_LMS.domain.Lesson;

import java.time.LocalDate;

public interface HomeTaskService {

    boolean createHomeTask(Lesson lesson, String task);

    void addHomeTask(Lesson lesson, String task);

    boolean changeDeadLine(HomeTask homeTask, LocalDate date);

}
