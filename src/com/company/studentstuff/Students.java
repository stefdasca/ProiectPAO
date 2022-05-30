package com.company.studentstuff;

import java.sql.Array;
import java.util.ArrayList;

public class Students {
    private String name, surname;
    private ArrayList<Double> grades;
    private ArrayList<String> hobbies;

    public Students(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.grades = new ArrayList<>();
        this.hobbies = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public ArrayList<Double> getGrades() {
        return grades;
    }

    public void setGrades(ArrayList<Double> grades) {
        this.grades = grades;
    }

    public void addGrade(Double grade){
        grades.add(grade);
    }

    public ArrayList<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(ArrayList<String> hobbies) {
        this.hobbies = hobbies;
    }

    public double getAverageGrades() {
        double sum = 0.0;
        for(int i = 0; i < grades.size(); ++i)
            sum = sum + grades.get(i);
        sum = sum / (0.0 + grades.size());
        return sum;
    }
}
