package com.max.CM_LMS.domain.dao.inDataBase;

import com.max.CM_LMS.domain.Student;
import com.max.CM_LMS.domain.User;
import com.max.CM_LMS.domain.dao.UserDao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcUserDaoImpl implements UserDao {

    private static String getIdQuery() {
        return "select id from USER where \"dateOfBirth\" = ? and \"lastName\" = ?";
    }

    private static String insertUserQuery() {
        return "insert into USER ( \"firstName\", \"lastName\" ,ROLE, \"dateOfBirth\")" +
                "values ( ?,?,?,? )";
    }

    private static String updateByIdQuery() {
        return "update USER set \"firstName\" = ?, \"lastName\" = ?, ROLE = ?, \"dateOfBirth\" = ? where id = ?;";
    }

    private static String deleteByIdQuery() {
        return "delete from USER where id = ?;";
    }

    @Override
    public List<User> getAll() throws Exception {
        List<User> users = new ArrayList<>();

        Connection connection = DbUtils.getConnection();
        Statement statement = connection.createStatement();

        String query = "select *from USER;";
        ResultSet result = statement.executeQuery(query);
        User user = new Student("-1", "-1", LocalDate.now());
        while (result.next()) {
            // create new user with another pointer
            user = new Student("-1", "-1", LocalDate.now());
            //fill user
            user.setId(result.getInt(1));
            user.setFirstName(result.getString(2));
            user.setLastName(result.getString(3));
            user.setRole(result.getString(4));
            user.setDateofBirth(LocalDate.parse(result.getString(5)));

            users.add(user);
        }
        //in that case when db is empty
        if (user.getFirstName().equals("-1")) {
            return null;
        }
        return users;
    }

    @Override
    public User saveUser(User user) throws Exception {
        if (user.getId() != 0 && user.getId() != null) {
            updateUser(user);
            return user;
        }
        Connection connection = DbUtils.getConnection();
        /*get insert query*/
        PreparedStatement statement = connection.prepareStatement(insertUserQuery());
        /*set values  firstName, lastName, role, dateOfBirth*/
        statement.setString(1, user.getFirstName());
        statement.setString(2, user.getLastName());
        if (user.getClass() == Student.class) {
            statement.setString(3, "student");
        } else {
            statement.setString(3, "teacher");
        }
        statement.setString(4, user.getDateofBirth().toString());
        /*executing a query*/
        try {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        /* now new user needs in id
         * id auto increments in db
         * i find new user in data base with his dateOfBirth and lastName
         * */
        statement = connection.prepareStatement(getIdQuery());
        statement.setString(1, user.getDateofBirth().toString());
        statement.setString(2, user.getLastName());
        ResultSet result = statement.executeQuery();
        int newId = 0;
        /*parse result*/
        while (result.next()) {
            newId = Integer.parseInt(result.getString(1));
        }
        user.setId(newId);
        return user;
    }


    @Override
    public User getUserById(int id) throws Exception {

        Connection connection = DbUtils.getConnection();
        Statement statement = connection.createStatement();

        String query = "select *from USER where  id =" + id + ";";
        ResultSet result = statement.executeQuery(query);
        User user = new Student("-1", "-1", LocalDate.now());
        while (result.next()) {
            /* fill user*/
            user.setId(result.getInt(1));
            user.setFirstName(result.getString(2));
            user.setLastName(result.getString(3));
            user.setRole(result.getString(4));
            user.setDateofBirth(LocalDate.parse(result.getString(5)));
        }
        /*in this case db doesn`t contain this user */
        if (user.getFirstName().equals("-1")) {
            return null;
        }
        return user;
    }

    @Override
    public boolean updateUser(User user) throws Exception {
        if (user.getId() == 0 || user.getId() == null) {
            return false;
        }
        Connection connection = DbUtils.getConnection();
        /*get insert query*/
        PreparedStatement statement = connection.prepareStatement(updateByIdQuery());
        /*set values  firstName, lastName, role, dateOfBirth*/
        statement.setString(1, user.getFirstName());
        statement.setString(2, user.getLastName());
        if (user.getRole() == null) {
            statement.setString(3, "student");
        } else {
            statement.setString(3, user.getRole());
        }
        statement.setString(4, user.getDateofBirth().toString());
        statement.setString(5, user.getId().toString());
        int res = -999;
        try {
            res = statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // if db doesn't contain  user executeUpdate will return 0 and method return false
            return res > 0;
        }

    }


    @Override
    public boolean deleteUserById(int id) throws Exception {
        Connection connection = DbUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement(deleteByIdQuery());
        statement.setString(1, Integer.toString(id));
        int result = -999;
        try {
            result = statement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {

            return result > 0;
        }

    }


}
