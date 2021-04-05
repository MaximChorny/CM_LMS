package com.max.CM_LMS.domain.service.interfaces;

import com.max.CM_LMS.domain.Group;
import com.max.CM_LMS.domain.Lesson;
import com.max.CM_LMS.domain.Student;
import com.max.CM_LMS.domain.Teacher;

 public interface GroupService {

    Group creareGroup(String name, String direction);

    boolean addStudent(Group group, Student student);

    boolean addTeacher(Group group, Teacher teacher);

    void createLesson(Group group, int amountOfLessons);

    // void createFeed(Group group);



}
