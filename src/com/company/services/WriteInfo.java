package com.company.services;

import com.company.employees.AuxiliaryEmployees;
import com.company.employees.Teachers;
import com.company.halls.Classrooms;
import com.company.halls.Laboratories;
import com.company.studentstuff.Events;
import com.company.studentstuff.Students;

import java.util.ArrayList;

public class WriteInfo
{
    public void printTeacher(Teachers t){
        System.out.println("Name and surname: " + t.getName() + " " + t.getSurname());
        System.out.println("Subject taught: " + t.getSubjecttaught());
        System.out.println("Age: " + t.getAge());
        System.out.println("Salary: " + t.getSalary());
    }

    public void printStudent(Students s){
        System.out.println("Name and surname: " + s.getName() + " " + s.getSurname());
        System.out.print("List of grades: ");
        ArrayList<Double> gr = s.getGrades();
        for(int i = 0; i < gr.size(); ++i)
            System.out.print(gr.get(i) + " ");
        System.out.println();
        ArrayList<String> hb = s.getHobbies();
        for(int i = 0; i < hb.size(); ++i)
            System.out.print(hb.get(i) + " ");
        System.out.println();
    }

    public void printEvents(Events e){
        System.out.println("Name of event: " + e.getEventName());
        System.out.println("Budget required: " + e.getBudget());
    }

    public void printAuxiliaryEmployee(AuxiliaryEmployees ae){
        System.out.println("Name and surname: " + ae.getName() + " " + ae.getSurname());
        System.out.println("Job: " + ae.getJob());
        System.out.println("Age: " + ae.getAge());
        System.out.println("Salary: " + ae.getSalary());
    }

    public void printLaboratories(Laboratories lb){
        System.out.println("Subject taught there :" + lb.getSubject());
        System.out.println("Dimensions: " + lb.getLength() + " " + lb.getWidth() + " " + lb.getRoomnumber());
    }

    public void printClassrooms(Classrooms lb){
        System.out.println("Class :" + lb.getClassnumber() + " " + lb.getLetter());
        System.out.println("Dimensions: " + lb.getLength() + " " + lb.getWidth() + " " + lb.getRoomnumber());
    }
}
