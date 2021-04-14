package com.max.CM_LMS.domain.dao;

import com.max.CM_LMS.domain.Lesson;

import java.sql.SQLException;
import java.util.List;

public interface LessonDao {
    List<Lesson> getAll() throws Exception;

    Lesson saveLessonTask(Lesson lesson) throws Exception;

    Lesson getLessonById(int id) throws Exception;

    boolean updateLesson(Lesson lesson) throws Exception;

    boolean deleteLessonById(int id) throws Exception;
}
