package com.company.connections;

import com.company.employees.AuxiliaryEmployees;
import com.company.employees.Employees;
import com.company.employees.Teachers;
import com.company.halls.Classrooms;
import com.company.halls.Halls;
import com.company.halls.Laboratories;
import com.company.studentstuff.Events;
import com.company.studentstuff.Students;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertInTable {
    private static InsertInTable instance;
    private InsertInTable()
    {

    }
    public static InsertInTable getInstance(){
        if(instance == null)
            instance = new InsertInTable();
        return instance;
    }
    public void AddEvent(Events event){
        String insert = "INSERT INTO events(eventname, budget) VALUES(?, ?)";
        Connection connection = DBConnection.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1, event.getEventName());
            preparedStatement.setInt(2, event.getBudget());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void AddStudent(Students student){
        String insert = "INSERT INTO students(name, bname) VALUES(?, ?)";
        Connection connection = DBConnection.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSurname());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void AddHall(Halls hall){
        String insert = "INSERT INTO halls(length, width, tip, extra) VALUES(?, ?, ?, ?)";
        Connection connection = DBConnection.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setInt(1, hall.getLength());
            preparedStatement.setInt(2, hall.getWidth());
            if(hall instanceof Laboratories)
            {
                preparedStatement.setString(3, "Laboratory");
                preparedStatement.setString(4, ((Laboratories) hall).getSubject());
            }
            else
            {
                preparedStatement.setString(3, "Classroom");
                String str = ((Classrooms) hall).getClassnumber() + Character.toString(((Classrooms) hall).getLetter());
                preparedStatement.setString(4, str);
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void AddEmployee(Employees employee){
        String insert = "INSERT INTO employees(name, surname, age, salary, tip, job) VALUES(?, ?, ?, ?, ?, ?)";
        Connection connection = DBConnection.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getSurname());
            preparedStatement.setInt(3, employee.getAge());
            preparedStatement.setInt(4, employee.getSalary());
            if(employee instanceof Teachers)
            {
                preparedStatement.setInt(5, 1);
                preparedStatement.setString(6, ((Teachers) employee).getSubjecttaught());
            }
            else
            {
                preparedStatement.setInt(5, 2);
                preparedStatement.setString(6, ((AuxiliaryEmployees) employee).getJob());
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
