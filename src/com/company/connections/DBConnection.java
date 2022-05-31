package com.company.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String name = "jdbc:mysql://localhost:3306/schoolmanagement";
    private static final String user = "root";
    private static final String password = "123456";
    private static Connection connection;

    private DBConnection(){

    }

    public static Connection getConnection(){
        try{
            if (connection == null || connection.isClosed())
            {
                connection = DriverManager.getConnection(name, user, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}