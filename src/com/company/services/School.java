package com.company.services;

import com.company.exceptions.InsufficientFundsException;
import com.company.studentstuff.Students;
import com.company.employees.AuxiliaryEmployees;
import com.company.employees.Teachers;
import com.company.halls.Classrooms;
import com.company.halls.Laboratories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class School {
    private ArrayList<Teachers> teacher = new ArrayList<>();
    private ArrayList<AuxiliaryEmployees> otheremployees = new ArrayList<>();
    private ArrayList<Students> students = new ArrayList<>();
    private ArrayList<Laboratories> labs = new ArrayList<>();
    private ArrayList<Classrooms> classrooms = new ArrayList<>();
    private Map<Integer, Integer> wages = new HashMap<>();
    private int cnt = 0;
    private ArrayList<String> events = new ArrayList<>();
    private int budget = 0;
    private int received = 0;
    private ArrayList<Integer> spending = new ArrayList<>();

    public Teachers createTeacher(String name, String surname, int age, int salary, String subjecttaught){
        Teachers t = new Teachers(name, surname, age, salary, subjecttaught);
        teacher.add(t);
        cnt++;
        wages.put(cnt, salary);
        return t;
    }

    public AuxiliaryEmployees createWorker(String name, String surname, int age, int salary, String job){
        AuxiliaryEmployees ae = new AuxiliaryEmployees(name, surname, age, salary, job);
        otheremployees.add(ae);
        cnt++;
        wages.put(cnt, salary);
        return ae;
    }

    public Students createStudent(String name, String surname){
        Students s = new Students(name, surname);
        students.add(s);
        return s;
    }

    public Laboratories createLab(int number, int width, int length, String subject){
        Laboratories lb = new Laboratories(number, width, length, subject);
        labs.add(lb);
        return lb;
    }

    public Classrooms createClass(int number, int width, int length, int classnumber, char letter){
        Classrooms cls = new Classrooms(number, width, length, classnumber, letter);
        classrooms.add(cls);
        return cls;
    }

    public void addEvent(String eventtype, int sum) throws InsufficientFundsException {
        events.add(eventtype);
        spending.add(sum);
        if(sum > budget){
            int required = sum - budget;
            throw new InsufficientFundsException(required);
        }
        else
            budget -= sum;
    }

    public void updateBudget(int amount){
        budget += amount;
        received += amount;
    }

    public int totalWage(){
        int total = 0;
        for(Map.Entry<Integer, Integer> emp : wages.entrySet())
        {
            total = total + emp.getValue();
        }
        return total;
    }

    public void addGrade(String name, String surname, double grade) {
        for(int i = 0; i < students.size(); ++i){
            Students s = students.get(i);
            if(s.getName() == name && s.getSurname() == surname){
                s.addGrade(grade);
            }
        }
    }

    public int RequiredBudget(){
        int total = 0;
        for(int i = 0; i < events.size(); ++i){
            total += spending.get(i);
        }

        for(int i = 0; i < teacher.size(); ++i){
            Teachers t = teacher.get(i);
            total += 12 * t.getSalary();
        }

        for(int i = 0; i < otheremployees.size(); ++i){
            AuxiliaryEmployees e = otheremployees.get(i);
            total += 12 * e.getSalary();
        }

        return total;
    }

    public int NecessaryFunds(){
        if(RequiredBudget() > received)
            return RequiredBudget() - received;
        else
            return 0;
    }

}
