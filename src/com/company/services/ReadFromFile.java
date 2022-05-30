package com.company.services;

import com.company.employees.*;
import com.company.halls.Classrooms;
import com.company.halls.Laboratories;
import com.company.studentstuff.Events;
import com.company.studentstuff.Grades;
import com.company.studentstuff.Students;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFile {
    public static ReadFromFile instance;
    public static synchronized ReadFromFile getInstance(){
        if(instance == null){
            instance = new ReadFromFile();
        }
        return instance;
    }

    public List<Teachers> readTeachers() {
        List<Teachers> staffTeachers = new ArrayList<>();
        try{
            BufferedReader buffer = new BufferedReader(new FileReader("src/com/company/files/teachers.csv"));
            String line = buffer.readLine();
            while(line != null)
            {
                String[] v = line.split(",");
                Teachers teacher = new Teachers(v[0], v[1], Integer.parseInt(v[2]), Integer.parseInt(v[3]), v[4]);
                staffTeachers.add(teacher);
                line = buffer.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return staffTeachers;
}

    public List<Students> readStudents() {
        List<Students> students = new ArrayList<>();
        try{
            BufferedReader buffer = new BufferedReader(new FileReader("src/com/company/files/students.csv"));
            String line = buffer.readLine();
            while(line != null)
            {
                String[] v = line.split(",");
                Students student = new Students(v[0], v[1]);
                students.add(student);
                line = buffer.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

    public List<AuxiliaryEmployees> readWorkers() {
        List<AuxiliaryEmployees> staff = new ArrayList<>();
        try{
            BufferedReader buffer = new BufferedReader(new FileReader("src/com/company/files/employees.csv"));
            String line = buffer.readLine();
            while(line != null)
            {
                String[] v = line.split(",");
                AuxiliaryEmployees worker = new AuxiliaryEmployees(v[0], v[1], Integer.parseInt(v[2]), Integer.parseInt(v[3]), v[4]);
                staff.add(worker);
                line = buffer.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return staff;
    }

    public List<Laboratories> readLabs() {
        List<Laboratories> labs = new ArrayList<>();
        try{
            BufferedReader buffer = new BufferedReader(new FileReader("src/com/company/files/halls.csv"));
            String line = buffer.readLine();
            while(line != null)
            {
                String[] v = line.split(",");
                Laboratories lab = new Laboratories(Integer.parseInt(v[0]), Integer.parseInt(v[1]), Integer.parseInt(v[2]), v[3]);
                labs.add(lab);
                line = buffer.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return labs;
    }

    public List<Classrooms> readClassrooms() {
        List<Classrooms> clasa = new ArrayList<>();
        try{
            BufferedReader buffer = new BufferedReader(new FileReader("src/com/company/files/classrooms.csv"));
            String line = buffer.readLine();
            while(line != null)
            {
                String[] v = line.split(",");
                Classrooms clas = new Classrooms(Integer.parseInt(v[0]), Integer.parseInt(v[1]), Integer.parseInt(v[2]), Integer.parseInt(v[3]), v[4].charAt(0));
                clasa.add(clas);
                line = buffer.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clasa;
    }

    public List<Grades> readGrades() {
        List<Grades> grades = new ArrayList<>();
        try{
            BufferedReader buffer = new BufferedReader(new FileReader("src/com/company/files/grades.csv"));
            String line = buffer.readLine();
            while(line != null)
            {
                String[] v = line.split(",");
                Grades gr = new Grades(v[0], v[1], Double.parseDouble(v[2]));
                grades.add(gr);
                line = buffer.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return grades;
    }

    public List<Events> readEvents() {
        List<Events> events = new ArrayList<>();
        try{
            BufferedReader buffer = new BufferedReader(new FileReader("src/com/company/files/events.csv"));
            String line = buffer.readLine();
            while(line != null)
            {
                String[] v = line.split(",");
                Events ev = new Events(v[0], Integer.parseInt(v[1]));
                events.add(ev);
                line = buffer.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return events;
    }
}
