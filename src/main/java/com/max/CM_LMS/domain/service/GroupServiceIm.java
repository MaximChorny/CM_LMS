package com.max.CM_LMS.domain.service;

import com.max.CM_LMS.domain.Group;
import com.max.CM_LMS.domain.Lesson;
import com.max.CM_LMS.domain.Student;
import com.max.CM_LMS.domain.Teacher;
import com.max.CM_LMS.domain.service.interfaces.GroupService;

import java.time.LocalDate;

public class GroupServiceIm implements GroupService {

    @Override
    public Group creareGroup(String name, String direction) {
        return new Group(name, direction , LocalDate.now());
    }

    @Override
    public boolean addStudent(Group group, Student student) {
      return group.addStudent(student);
    }

    @Override
    public boolean addTeacher(Group group, Teacher teacher) {
        return group.addTeacher(teacher);
    }

    @Override
    public void createLesson(Group group, int amountOfLessons) {
        for (int i = 0; i < amountOfLessons; i++){
             group.addLeson(new Lesson());
        }
    }

}
