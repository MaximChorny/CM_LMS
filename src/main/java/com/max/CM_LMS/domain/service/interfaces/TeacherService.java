package com.max.CM_LMS.domain.service.interfaces;

import com.max.CM_LMS.domain.Group;
import com.max.CM_LMS.domain.Teacher;

import java.time.LocalDate;

public interface TeacherService {

    Teacher createNewTeacher(String firstName, String lastName, LocalDate dateofBirth, String role);

    boolean addTeacherToGroup(Group group, Teacher teacher);

}

