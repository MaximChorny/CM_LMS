package com.max.CM_LMS.domain.service;

import com.max.CM_LMS.domain.HomeTask;
import com.max.CM_LMS.domain.HomeWork;
import com.max.CM_LMS.domain.Student;
import com.max.CM_LMS.domain.Teacher;
import com.max.CM_LMS.domain.service.interfaces.HomeWorkService;

public class HomeWorkServiceIm implements HomeWorkService {

    @Override
    public boolean addHomeWorkToStudent(Student student, HomeTask homeTask, String str) {
        return student.addHomework(new HomeWork(student, homeTask, str));
    }

    @Override
    public void evaluateHomeWork(HomeWork homeWork, int mark) {
      homeWork.setMark(mark);
    }
}
