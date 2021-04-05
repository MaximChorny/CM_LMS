package com.max.CM_LMS.domain.service;

import com.max.CM_LMS.domain.Group;
import com.max.CM_LMS.domain.Student;
import com.max.CM_LMS.domain.Teacher;
import com.max.CM_LMS.domain.service.interfaces.StudentService;

import java.time.LocalDate;

public class StudentServiceIm implements StudentService {
    @Override
    public Student createNewStudent(String firstName, String lastName, LocalDate dateofBirth) {
        return new Student(firstName,lastName,dateofBirth);
    }

    @Override
    public boolean addStudentToGroup(Group group, Student student) {
        return group.addStudent(student);
    }

}
