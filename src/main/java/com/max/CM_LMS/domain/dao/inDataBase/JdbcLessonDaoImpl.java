package com.max.CM_LMS.domain.dao.inDataBase;

import com.max.CM_LMS.domain.HomeTask;
import com.max.CM_LMS.domain.Lesson;
import com.max.CM_LMS.domain.dao.LessonDao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JdbcLessonDaoImpl implements LessonDao {
    final JdbcHomeTaskImpl homeTaskFromBase = new JdbcHomeTaskImpl();

    private String insertLessonQuery() {
        return "insert into LESSON(topic, date, materials) VALUES ( ?, ?, ?);";
    }

    private String deleteLessonByIdQuery() {
        return "delete from LESSON where ID = ?;";
    }

    private String updateLessonQuery() {
        return "update LESSON set TOPIC = ?, DATE = ?, MATERIALS = ? where ID = ?;";
    }

    @Override
    public List<Lesson> getAll() throws Exception {
        List<Lesson> lessons = new ArrayList<>();

        Connection connection = DbUtils.getConnection();
        Statement statement = connection.createStatement();

        String queryToSelect = "select * from LESSON;";
        ResultSet result = statement.executeQuery(queryToSelect);
        Lesson lesson = new Lesson("-1", LocalDate.now());
        while (result.next()){
            //create new pointer
            lesson = new Lesson("-1", LocalDate.now());
            //set values id, topic, date, materials
            lesson.setId(result.getInt(1));
            lesson.setTopic(result.getString(2));
            lesson.setDate(LocalDate.parse(result.getString(3)));
            lesson.setMaterials(result.getString(4));
            lessons.add(lesson);
        }
        //in that case db is empty
        if(lesson.getTopic().equals("-1")){
            return null;
        }
        return lessons;
    }

    @Override
    public Lesson saveLessonTask(Lesson lesson) throws Exception {
        if (lesson.getId() != 0 && lesson.getId() != null ) {
            updateLesson(lesson);
            return lesson;
        }
        Connection connection = DbUtils.getConnection();
        /*get insert query*/
        PreparedStatement statement = connection.prepareStatement(insertLessonQuery(), Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, lesson.getTopic());
        statement.setString(2, lesson.getDate().toString());
        statement.setString(3, lesson.getMaterials());

        Iterator<HomeTask>iterator = lesson.getHomeTasks().iterator();
        // update all homeTask
        while (iterator.hasNext()){
            homeTaskFromBase.saveHomeTask(iterator.next());
        }
        /*executing a query*/
        int newId = 0;
        try {
            statement.executeUpdate();
            ResultSet result = statement.getGeneratedKeys();
            if (result.next()) {
                newId = result.getInt(1);
            }
            lesson.setId(newId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        lesson.setId(newId);
        return lesson;
    }


    @Override
    public Lesson getLessonById(int id) throws Exception {

        Connection connection = DbUtils.getConnection();
        Statement statement = connection.createStatement();

        String query = "select *from LESSON where ID= " + id + ";";
        ResultSet result = statement.executeQuery(query);
        Lesson lesson = new Lesson("-1", LocalDate.now());
        while (result.next()) {
            // set values id, topic, date, materials
            lesson.setId(result.getInt(1));
            lesson.setTopic(result.getString(2));
            lesson.setDate(LocalDate.parse(result.getString(3)));
            lesson.setMaterials(result.getString(4));
        }
        // it that case db doesn't lesson with it id
        if (lesson.getTopic().equals("-1")) {
            return null;
        }
        return lesson;
    }

    @Override
    public boolean updateLesson(Lesson lesson) throws Exception {
        if (lesson.getId() == 0 || lesson.getId() == null) {
            return false;
        }
        Connection connection = DbUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement(updateLessonQuery());

        /* set values topic, date, materials, id to update*/
        statement.setString(1, lesson.getTopic());
        statement.setString(2, lesson.getDate().toString());
        statement.setString(3, lesson.getMaterials());
        statement.setString(4, lesson.getId().toString());

        Iterator<HomeTask>iterator = lesson.getHomeTasks().iterator();
        // update all hometasks
        while (iterator.hasNext()){
            homeTaskFromBase.updateHomeTask(iterator.next());
        }
        int res = -999;
        res = statement.executeUpdate();
        // if doesn't
        return res > 0;
    }


    @Override
    public boolean deleteLessonById(int id) throws Exception {
        Connection connection = DbUtils.getConnection();
        /*get insert query*/
        PreparedStatement statement = connection.prepareStatement(deleteLessonByIdQuery());
        /* set id*/
        statement.setString(1, Integer.toString(id));
        int result = -999;
        try {
            result = statement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        /*
         * in case when there isn't group with input id
         * statement.executeUpdate() will return 0 (zero line was affected)
         * and result=0
         */
        return result > 0;
    }

}
