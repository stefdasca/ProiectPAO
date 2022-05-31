package com.company.connections;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    private static CreateTable instance;
    private CreateTable()
    {

    }
    public static CreateTable getInstance(){
        if(instance == null)
            instance = new CreateTable();
        return instance;
    }
    public void CreateTables() throws SQLException {
        String Halls = "CREATE TABLE IF NOT EXISTS halls" +
                "(idHalls int PRIMARY KEY AUTO_INCREMENT NOT NULL, " +
                "length int NOT NULL, " +
                "width int NOT NULL, " +
                "tip varchar(20), " +
                "extra varchar(20))";
        String Employees = "CREATE TABLE IF NOT EXISTS employees" +
                "(idEmployees int PRIMARY KEY AUTO_INCREMENT NOT NULL, " +
                "name varchar(30), " +
                "surname varchar(30), " +
                "age int NOT NULL, " +
                "salary int NOT NULL, " +
                "tip int NOT NULL, " +
                "job varchar(30))";
        String Events = "CREATE TABLE IF NOT EXISTS events" +
                "(idEvents int PRIMARY KEY AUTO_INCREMENT NOT NULL, " +
                "eventname varchar(50), " +
                "budget int NOT NULL)";
        String Students = "CREATE TABLE IF NOT EXISTS students" +
                "(idStudents int PRIMARY KEY AUTO_INCREMENT NOT NULL, " +
                "name varchar(30), " +
                "bname varchar(30))";
        Connection connection = DBConnection.getConnection();
        try{
            Statement statement = connection.createStatement();
            statement.execute(Halls);
            statement.execute(Employees);
            statement.execute(Events);
            statement.execute(Students);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection.close();
    }
}
