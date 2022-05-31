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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateTable {
    private static UpdateTable updateInTable;
    private UpdateTable(){

    }
    public static UpdateTable getInstance(){
        if(updateInTable == null)
            updateInTable = new UpdateTable();
        return updateInTable;
    }
    public void UpdateEvent(int newBudget, int id){
        String upd = "UPDATE events SET budget=? WHERE idEvents=?";
        Connection connection = DBConnection.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(upd);
            preparedStatement.setInt(1, newBudget);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void UpdateStudent(String nume, int id){
        String upd = "UPDATE students SET name=? WHERE idStudents=?";
        Connection connection = DBConnection.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(upd);
            preparedStatement.setString(1, nume);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void UpdateHall(int length, int width, int id){
        String upd = "UPDATE halls SET length=?, width=? WHERE idHalls=?";
        Connection connection = DBConnection.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(upd);
            preparedStatement.setInt(1, length);
            preparedStatement.setInt(2, width);
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void UpdateEmployee(int age, int salary, int id){
        String upd = "UPDATE employees SET age=?, salary=? WHERE idEmployees=?";
        Connection connection = DBConnection.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(upd);
            preparedStatement.setInt(1, age);
            preparedStatement.setInt(2, salary);
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
