package com.max.CM_LMS.domain.service;

import com.max.CM_LMS.domain.Group;
import com.max.CM_LMS.domain.Teacher;
import com.max.CM_LMS.domain.service.interfaces.TeacherService;

import java.time.LocalDate;

public class TeacherServiceIm implements TeacherService {
    @Override
    public Teacher createNewTeacher(String firstName, String lastName, LocalDate dateofBirth, String role) {
      return new Teacher(firstName, lastName, dateofBirth, role);
    }

    @Override
    public boolean addTeacherToGroup(Group group, Teacher teacher) {
        return group.addTeacher(teacher);
    }
}
