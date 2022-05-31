package com.company.connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteInTable {
    private static DeleteInTable deleteInTable;
    private DeleteInTable(){

    }
    public static DeleteInTable getInstance(){
        if(deleteInTable == null)
            deleteInTable = new DeleteInTable();
        return deleteInTable;
    }
    public void deleteEvent(int id){
        String delete = "DELETE FROM events where idEvents=?";
        Connection connection = DBConnection.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteEmployee(int id){
        String delete = "DELETE FROM employees where idEmployees=?";
        Connection connection = DBConnection.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteStudent(int id){
        String delete = "DELETE FROM students where idStudents=?";
        Connection connection = DBConnection.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteHall(int id){
        String delete = "DELETE FROM halls where idHalls=?";
        Connection connection = DBConnection.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
