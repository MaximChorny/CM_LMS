package com.max.CM_LMS.domain.dao;

import com.max.CM_LMS.domain.Lesson;

import java.util.List;

public interface LessonDao {
    List<Lesson> getAll();

    Lesson saveLessonTask(Lesson lesson);

    Lesson getLessonById(int id);

    boolean updateLesson(Lesson lesson);

    boolean deleteLessonById(int id);
}
