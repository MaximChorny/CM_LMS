package com.max.CM_LMS.domain.dao;

import com.max.CM_LMS.domain.Lesson;

import java.sql.SQLException;
import java.util.List;

public interface LessonDao {
    List<Lesson> getAll() throws SQLException;

    Lesson saveLessonTask(Lesson lesson) throws SQLException;

    Lesson getLessonById(int id) throws SQLException;

    boolean updateLesson(Lesson lesson) throws SQLException;

    boolean deleteLessonById(int id) throws SQLException;
}
