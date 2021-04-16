package com.max.CM_LMS.domain.dao.inDataBase;

import com.max.CM_LMS.domain.HomeWork;
import com.max.CM_LMS.domain.Student;
import com.max.CM_LMS.domain.dao.HomeWorkDao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcHomeWorkDaoImpl implements HomeWorkDao {
    final JdbcUserDaoImpl userFromBase = new JdbcUserDaoImpl();
    final JdbcHomeTaskImpl homeTaskFromBase = new JdbcHomeTaskImpl();

    private String insertHomeWorkQuery() {
        return "insert into HOMEWORK (ID_STUDENT, \"id_homeTask\", \"whatStudentDid\", \"dateSubmit\", MARK)" +
                " VALUES ( ?, ?, ?, ?, ? );";
    }

    private String updateHomeWorkQuery() {
        return "update HOMEWORK set ID_STUDENT = ? , \"id_homeTask\" = ?, \"whatStudentDid\" = ?, \"dateSubmit\"= ?, MARK = ? where ID = ?;";
    }

    private String deleteHomeWorkByIdQuery() {
        return "delete from HOMEWORK where id = ?;";
    }

    @Override
    public List<HomeWork> getAll() throws Exception {
        List<HomeWork> homeWorks = new ArrayList<>();

        Connection connection = DbUtils.getConnection();
        Statement statement = connection.createStatement();

        String queryToSelect = "select *from HOMEWORK;";
        ResultSet result = statement.executeQuery(queryToSelect);
        HomeWork homeWork = new HomeWork();
        homeWork.setId(-99);
        while (result.next()) {
            homeWork = new HomeWork();
            homeWork.setId(result.getInt(1));
            homeWork.setAuthor((Student) userFromBase.getUserById(result.getInt(2)));
            homeWork.setHomeTask(homeTaskFromBase.getHomeTaskById(result.getInt(3)));
            homeWork.setWhatStudentDid(result.getString(4));
            homeWork.setDateSubmitted(LocalDate.parse(result.getString(5)));
            homeWork.setMark(result.getInt(6));
            homeWorks.add(homeWork);
        }
        if (homeWork.getId().equals(-99)) {
            return null;
        }
        return homeWorks;
    }

    @Override
    public HomeWork save(HomeWork homeWork) throws Exception {
        if (homeWork.getId() != 0 && homeWork.getId() != null) {
            updateHomeWork(homeWork);
            return homeWork;
        }
        Connection connection = DbUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement(insertHomeWorkQuery(), Statement.RETURN_GENERATED_KEYS);

        int newId = 0;
        try {
            statement.setString(1, homeWork.getAuthor().getId().toString());
            statement.setString(2, homeWork.getHomeTask().getId().toString());
            statement.setString(3, homeWork.getWhatStudentDid());
            statement.setString(4, homeWork.getDateSubmitted().toString());
            statement.setString(5, "" + homeWork.getMark());
            statement.executeUpdate();
            ResultSet result = statement.getGeneratedKeys();
            if (result.next()) {
                newId = result.getInt(1);
            }
            homeWork.setId(newId);
        } catch (Exception e) {
            System.out.println("wrong parameters in homeWork");
            e.printStackTrace();
        } finally {
            return homeWork;
        }
    }


    @Override
    public HomeWork getHomeWork(int id) throws Exception {

        Connection connection = DbUtils.getConnection();
        Statement statement = connection.createStatement();

        String query = "select *from HOMEWORK where id = " + id + ";";
        ResultSet result = statement.executeQuery(query);
        HomeWork homeWork = new HomeWork();
        if (result.next()) {
            homeWork.setId(result.getInt(1));
            homeWork.setAuthor((Student) userFromBase.getUserById(result.getInt(2)));
            homeWork.setHomeTask(homeTaskFromBase.getHomeTaskById(result.getInt(3)));
            homeWork.setWhatStudentDid(result.getString(4));
            homeWork.setDateSubmitted(LocalDate.parse(result.getString(5)));
            homeWork.setMark(result.getInt(6));

        } else {
            return null;
        }
        return homeWork;
    }

    @Override
    public boolean updateHomeWork(HomeWork homeWork) throws Exception {
        if (homeWork.getId() == 0 || homeWork.getId() == null) {
            return false;
        }
        Connection connection = DbUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement(updateHomeWorkQuery());

        statement.setString(1, homeWork.getAuthor().getId().toString());
        statement.setString(2, homeWork.getHomeTask().getId().toString());
        statement.setString(3, homeWork.getWhatStudentDid());
        statement.setString(4, homeWork.getDateSubmitted().toString());
        statement.setString(5, "" + homeWork.getMark());
        int res = -999;
        try {
            res = statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("wrong parameters in homeWork");
            e.printStackTrace();
        } finally {
            return res > 0;
        }
    }


    @Override
    public boolean deleteHomeWorkById(int id) throws Exception {
        Connection connection = DbUtils.getConnection();
        /*get insert query*/
        PreparedStatement statement = connection.prepareStatement(deleteHomeWorkByIdQuery());
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
