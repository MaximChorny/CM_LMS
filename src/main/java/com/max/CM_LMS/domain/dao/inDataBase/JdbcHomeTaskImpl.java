package com.max.CM_LMS.domain.dao.inDataBase;

import com.max.CM_LMS.domain.HomeTask;
import com.max.CM_LMS.domain.Lesson;
import com.max.CM_LMS.domain.dao.HomeTaskDao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcHomeTaskImpl implements HomeTaskDao {
    private final JdbcLessonDaoImpl lessonFromBase = new JdbcLessonDaoImpl();

    private String insertHomeTaskQuery() {
        return "insert into HOMETASK(task, date, \"deadLine\", id_lesson) VALUES ( ?, ?, ?, ? );";
    }

    private String UpdateHomeTaskQuery() {
        return "update HOMETASK set TASK = ?, DATE = ?, \"deadLine\" = ?, ID_LESSON = ?  where ID = ?;";
    }

    private String deleteHomeTaskByIdQuery() {
        return "delete from HOMETASK where id = ?;";
    }

    @Override
    public List<HomeTask> getAll() throws Exception {
        List<HomeTask> homeTasks = new ArrayList<>();

        Connection connection = DbUtils.getConnection();
        Statement statement = connection.createStatement();

        String queryToSelect = "select *from HOMETASK;";
        ResultSet result = statement.executeQuery(queryToSelect);
        HomeTask homeTask;
        Lesson lesson = lessonFromBase.getLessonById(result.getInt(5));
        if (lesson == null) {
            return null;
        }
        while (result.next()) {
            homeTask = new HomeTask("-1", LocalDate.now(), LocalDate.now());
            homeTask.setId(result.getInt(1));
            homeTask.setTask(result.getString(2));
            homeTask.setDate(LocalDate.parse(result.getString(3)));
            homeTask.setDeadLine(LocalDate.parse(result.getString(4)));
            homeTask.setLesson(lesson);
            homeTasks.add(homeTask);
        }
        return homeTasks;
    }

    @Override
    public HomeTask saveHomeTask(HomeTask homeTask) throws Exception {
        if (homeTask.getId() != 0 && homeTask.getId() != null) {
            updateHomeTask(homeTask);
            return homeTask;
        }
        Connection connection = DbUtils.getConnection();

        /*get insert query*/
        PreparedStatement statement = connection.prepareStatement(insertHomeTaskQuery(), Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, homeTask.getTask());
        statement.setString(2, homeTask.getDate().toString());
        statement.setString(3, homeTask.getDeadLine().toString());
        statement.setString(4, homeTask.getLesson().getId().toString());
        statement.setString(5, homeTask.getId().toString());
        int newId = 0;
        try {
            statement.executeUpdate();
            ResultSet result = statement.getGeneratedKeys();
            if (result.next()) {
                newId = result.getInt(1);
            }
            homeTask.setId(newId);
        } catch (Exception e) {
            System.out.println("wrong parameters in homeTask");
            e.printStackTrace();
        } finally {

            return homeTask;
        }

    }


    @Override
    public HomeTask getHomeTaskById(int id) throws Exception {

        Connection connection = DbUtils.getConnection();
        Statement statement = connection.createStatement();

        String query = "select *from HOMETASK where id = " + id + ";";
        ResultSet result = statement.executeQuery(query);
        HomeTask homeTask = new HomeTask("-1", LocalDate.now(), LocalDate.now());
        Lesson lesson = lessonFromBase.getLessonById(result.getInt(5));
        if (lesson == null) {
            return null;
        }
        while (result.next()) {
            homeTask.setId(result.getInt(1));
            homeTask.setTask(result.getString(2));
            homeTask.setDate(LocalDate.parse(result.getString(3)));
            homeTask.setDeadLine(LocalDate.parse(result.getString(4)));
            homeTask.setLesson(lesson);
        }

        return homeTask;
    }

    @Override
    public boolean updateHomeTask(HomeTask homeTask) throws Exception {
        if (homeTask.getId() == 0 || homeTask.getId() == null) {
            return false;
        }

        Connection connection = DbUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement(UpdateHomeTaskQuery());

        statement.setString(1, homeTask.getTask());
        statement.setString(2, homeTask.getDate().toString());
        statement.setString(3, homeTask.getDeadLine().toString());
        statement.setString(4, homeTask.getLesson().getId().toString());
        int res = -999;
        try {
            res = statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("wrong parameters in homeTask");
            e.printStackTrace();
        } finally {
            return res > 0;
        }
    }


    @Override
    public boolean deleteHomeTaskById(int id) throws Exception {
        Connection connection = DbUtils.getConnection();

        /*get insert query*/
        PreparedStatement statement = connection.prepareStatement(deleteHomeTaskByIdQuery());
        /* set id*/
        statement.setString(1, Integer.toString(id));
        int result = -999;
        try {
            result = statement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return result > 0;
    }


}
