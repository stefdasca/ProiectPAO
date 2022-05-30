package com.company;
import com.company.employees.AuxiliaryEmployees;
import com.company.employees.Teachers;
import com.company.exceptions.InsufficientFundsException;
import com.company.halls.Classrooms;
import com.company.halls.Laboratories;
import com.company.services.ReadFromFile;
import com.company.services.School;
import com.company.services.WriteInfo;
import com.company.services.WriteToAudit;
import com.company.studentstuff.Events;
import com.company.studentstuff.Grades;
import com.company.studentstuff.Students;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        School scoala = new School();

        WriteToAudit audit = new WriteToAudit();
        audit.DeleteFromAudit();

        ArrayList<Double> note = null;
        ArrayList<String> hobby = null;

        ReadFromFile reader = new ReadFromFile();

        List<Teachers> profs = reader.readTeachers();
        List<Students> stud = reader.readStudents();
        List<AuxiliaryEmployees> workers = reader.readWorkers();
        List<Laboratories> labs = reader.readLabs();
        List<Classrooms> classes = reader.readClassrooms();
        List<Grades> grades = reader.readGrades();
        List<Events> events = reader.readEvents();

        WriteInfo wr = new WriteInfo();

        Students s1 = scoala.createStudent("Alexandru", "Georgescu");
        wr.printStudent(s1);
        audit.WriteToAudit("Student info was printed");
//        Students s2 = scoala.createStudent("Maria", "Popescu");
//        Students s3 = scoala.createStudent("Anca", "Coman");
//        Students s4 = scoala.createStudent("Radu", "Campeanu");
//        Students s5 = scoala.createStudent("Bogdan", "Blejan");

         Teachers t1 = scoala.createTeacher("Sergiu", "Nistor", 52, 5000, "Matematica");
        wr.printTeacher(t1);
        audit.WriteToAudit("Teacher info was printed");
//        Teachers t2 = scoala.createTeacher("Maria", "Dragan", 48, 3800, "Engleza");
//        Teachers t3 = scoala.createTeacher("Raluca", "Alexandrescu", 28, 4000, "Romana");
//        Teachers t4 = scoala.createTeacher("Eugen", "Ionescu", 28, 3000, "Istorie");
//        Teachers t5 = scoala.createTeacher("Nicusor", "Stanciu", 30, 2500, "Sport");

        AuxiliaryEmployees e1 = scoala.createWorker("Constantin", "Popa", 33, 2000, "Contabil");
        wr.printAuxiliaryEmployee(e1);
        audit.WriteToAudit("Auxiliary employee info was printed");
//        AuxiliaryEmployees e2 = scoala.createWorker("Ecaterina", "Enaru", 52, 2400, "Bibliotecar");
//        AuxiliaryEmployees e3 = scoala.createWorker("Carmen", "Ivan", 45, 4300, "Secretar");
//        AuxiliaryEmployees e4 = scoala.createWorker("Letitia", "Romanita", 59, 4000, "Administrator");
//        AuxiliaryEmployees e5 = scoala.createWorker("Dragos", "Sava", 41, 3500, "Instalator");

        Laboratories lab1 = scoala.createLab(1, 20, 10, "Informatica");
        wr.printLaboratories(lab1);

        audit.WriteToAudit("Laboratory info was printed");
//        Laboratories lab2 = scoala.createLab(2, 15, 15, "Informatica");
//        Laboratories lab3 = scoala.createLab(3, 12, 12, "Chimie");
//        Laboratories lab4 = scoala.createLab(4, 10, 10, "Biologie");
//        Laboratories lab5 = scoala.createLab(5, 15, 18, "Fizica");

        Classrooms c1 = scoala.createClass(1, 10, 10, 12, 'A');
        wr.printClassrooms(c1);

        audit.WriteToAudit("Classroom info was printed");
//        Classrooms c2 = scoala.createClass(2, 10, 8, 5, 'B');
//        Classrooms c3 = scoala.createClass(3, 4, 15, 8, 'A');
//        Classrooms c4 = scoala.createClass(4, 8, 12, 11, 'C');

//        scoala.addGrade("Alexandru", "Georgescu", 8.00);
//        scoala.addGrade("Maria", "Popescu", 5.50);


        scoala.updateBudget(100);

        audit.WriteToAudit("Bem si 7 zile bem");
        try {
            scoala.addEvent("Excursie", 2000);
            scoala.addEvent("Festivitate", 3000);
            scoala.addEvent("Tabla", 1500);
            scoala.addEvent("PC", 2000);
        }
        catch(InsufficientFundsException e){
            System.out.println("Ai nevoie de " + e.getAmount());
        }
        System.out.print("Fondul de salarii lunar al scolii este: ");
        System.out.println(scoala.totalWage());

        System.out.print("Bugetul anual al scolii ar trebui sa fie: ");
        System.out.println(scoala.RequiredBudget());

        System.out.println(scoala.NecessaryFunds());


    }
}
