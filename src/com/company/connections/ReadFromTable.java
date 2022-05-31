package com.company.connections;

import com.company.employees.AuxiliaryEmployees;
import com.company.employees.Teachers;
import com.company.halls.Classrooms;
import com.company.halls.Laboratories;
import com.company.services.WriteInfo;
import com.company.studentstuff.Events;
import com.company.studentstuff.Students;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class ReadFromTable {
    private static ReadFromTable readTable;
    private ReadFromTable(){

    }
    public static ReadFromTable getInstance(){
        if(readTable == null)
            readTable = new ReadFromTable();
        return readTable;
    }
    public void readEvent(){
        String select = "SELECT * FROM events";
        Connection connection = DBConnection.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(select);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                Events event = new Events(resultSet.getString(2), resultSet.getInt(3));
                System.out.println(event.getEventName() + " " + event.getBudget());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void readStudent(){
        String select = "SELECT * FROM students";
        Connection connection = DBConnection.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(select);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                Students student = new Students(resultSet.getString(2), resultSet.getString(3));
                System.out.println(student.getName() + " " + student.getSurname());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void readEmployee(){
        String select = "SELECT * FROM employees";
        Connection connection = DBConnection.getConnection();
        WriteInfo wr = new WriteInfo();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(select);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                if(resultSet.getInt(5) == 1) {
                    Teachers teacher = new Teachers(resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getInt(5), resultSet.getString(6));
                    wr.printTeacher(teacher);
                }
                else {
                    AuxiliaryEmployees emp = new AuxiliaryEmployees(resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getInt(5), resultSet.getString(6));
                    wr.printAuxiliaryEmployee(emp);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void readHall(){
        String select = "SELECT * FROM halls";
        Connection connection = DBConnection.getConnection();
        WriteInfo wr = new WriteInfo();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(select);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                if(resultSet.getString(4).equals("Laboratory")) {
                    Laboratories lab = new Laboratories(resultSet.getInt(2), resultSet.getInt(3), resultSet.getInt(4), resultSet.getString(5));
                    wr.printLaboratories(lab);
                }
                else {
                    String str = resultSet.getString(5);
                    char x = str.charAt(str.length() - 1);
                    String str2 = str.substring(0, str.length() - 1);
                    Classrooms cls = new Classrooms(resultSet.getInt(2), resultSet.getInt(3), resultSet.getInt(4), Integer.parseInt(str2), x);
                    wr.printClassrooms(cls);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
