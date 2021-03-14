package com.max.CM_LMS.domain.service;

import com.max.CM_LMS.domain.Group;
import com.max.CM_LMS.domain.Lesson;
import com.max.CM_LMS.domain.service.interfaces.LessonService;

import java.time.LocalDate;

public class LessonServiceIm implements LessonService {

    @Override
    public void addLesson(Group group, String topic) {
        group.addLeson(new Lesson(topic, LocalDate.now()));
    }

}
