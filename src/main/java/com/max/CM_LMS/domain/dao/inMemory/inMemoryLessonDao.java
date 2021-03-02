package com.max.CM_LMS.domain.dao.inMemory;

import com.max.CM_LMS.domain.HomeworkTask;
import com.max.CM_LMS.domain.Lesson;
import com.max.CM_LMS.domain.dao.LessonDao;
import com.max.CM_LMS.domain.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class inMemoryLessonDao implements LessonDao {

    @Override
    public List<Lesson> getAll() {
        return new ArrayList<>(Persistence.getLessons().values());
    }

    @Override
    public Lesson saveLessonTask(Lesson lesson) {
        int newId = Persistence.getNewId(Persistence.getLessons());
        lesson.setId(newId);
        Persistence.getLessons().put(newId, lesson);
        return lesson;
    }

    @Override
    public Lesson getLessonById(int id) {
        if (Persistence.getLessons().containsKey(id)) {
            return Persistence.getLessons().get(id);
        }
         throw new NoSuchElementException("Wrong id");
    }

    @Override
    public boolean updateLesson(Lesson lesson) {
        int id = lesson.getId();
        Map<Integer, Lesson> lessons = Persistence.getLessons();
        if (lessons.containsKey(id)) {
            lessons.put(id, lesson);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteLessonById(int id) {
        Map<Integer, Lesson> lessons = Persistence.getLessons();
        if (lessons.containsKey(id)) {
            lessons.remove(id);
            return true;
        }
        return false;
    }
}
