package com.max.CM_LMS.domain.service.interfaces;

import com.max.CM_LMS.domain.HomeTask;
import com.max.CM_LMS.domain.HomeWork;
import com.max.CM_LMS.domain.Student;
import com.max.CM_LMS.domain.Teacher;

public interface HomeWorkService {

    boolean addHomeWorkToStudent(Student student, HomeTask homeTask, String str);

    void estimateHomeWork(HomeWork homeWork, int mark);

}
