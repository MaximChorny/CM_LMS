package com.max.CM_LMS.domain.dao.inDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {
    private static final  String URL = "jdbc:h2:file:C:\\Users\\Максим\\IdeaProjects\\CM_LMS\\src\\database\\please";
    private  static final String Driver = "org.h2.Driver";

    public static Connection getConnection() throws Exception {

        Class.forName(Driver);
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
         return connection;
    }
}
