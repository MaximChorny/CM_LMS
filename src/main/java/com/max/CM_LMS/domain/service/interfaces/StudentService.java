package com.max.CM_LMS.domain.service.interfaces;

import com.max.CM_LMS.domain.Group;
import com.max.CM_LMS.domain.Student;
import com.max.CM_LMS.domain.Teacher;

import java.time.LocalDate;

public interface StudentService {

    Student createNewStudent(String firstName, String lastName, LocalDate dateofBirth);

    boolean addStudentToGroup(Group group, Student student);

}
