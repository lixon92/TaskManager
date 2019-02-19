package ru.atkachev.tm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    final private static String DB_DRIVER = "com.mysql.jdbc.Driver";
    final private static String DB_URL = "jdbc:mysql://127.0.0.1:3306/task_manager";
    final private static String DB_USERNAME = "root";
    final private static String DB_PASSWORD = "root";

    public static Connection getConnection(){

        Connection connection = null;

        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.
                    getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;

    }

}
