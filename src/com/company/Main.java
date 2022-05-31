package com.company;
import com.company.connections.*;
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
import com.mysql.cj.x.protobuf.MysqlxCrud;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static void ShowOptions() {
        System.out.println("Selectati optiunea dorita");
        System.out.println("1: Se adauga un elev");
        System.out.println("2: Se adauga un profesor");
        System.out.println("3: Se adauga un angajat");
        System.out.println("4: Se adauga un laborator");
        System.out.println("5: Se adauga o sala de clasa");
        System.out.println("6: Se adauga un eveniment");
        System.out.println("7: Se actualizeaza bugetul scolii");
        System.out.println("8: Se afiseaza fondul de salarii al scolii");
        System.out.println("9: Se afiseaza bugetul necesar al scolii");
        System.out.println("10: Se actualizeaza un elev");
        System.out.println("11: Se actualizeaza un angajat");
        System.out.println("12: Se actualizeaza o sala");
        System.out.println("13: Se actualizeaza un eveniment");
        System.out.println("14: Se afiseaza elevii");
        System.out.println("15: Se afiseaza angajatii");
        System.out.println("16: Se afiseaza salile");
        System.out.println("17: Se afiseaza evenimentele");
        System.out.println("18: Se sterge un elev");
        System.out.println("19: Se sterge un angajat");
        System.out.println("20: Se sterge o sala");
        System.out.println("21: Se sterge un eveniment");
        System.out.println("22: Se iese din meniu");
    }

    public static void main(String[] args) throws IOException, SQLException {
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

        Connection conn = DBConnection.getConnection();
        CreateTable cr = CreateTable.getInstance();
        InsertInTable insr = InsertInTable.getInstance();
        UpdateTable upd = UpdateTable.getInstance();
        ReadFromTable rd = ReadFromTable.getInstance();
        DeleteInTable dl = DeleteInTable.getInstance();

        Scanner scanner = new Scanner(System.in);

        System.out.println("A mers conexiunea");

        // cr.CreateTables();
        System.out.println("A creat tabele");
        // meniul

        while(true)
        {
            ShowOptions();
            int command = scanner.nextInt();
            if(command == 1){
                String name, surname;
                name = scanner.nextLine();
                surname = scanner.nextLine();
                Students s = scoala.createStudent(name, surname);
                stud.add(s);
                wr.printStudent(s);
                insr.AddStudent(s);
                audit.WriteToAudit("Student info was printed");
            }
            if(command == 2){
                String name, surname, subject;
                int age, salary;
                name = scanner.nextLine();
                surname = scanner.nextLine();
                age = scanner.nextInt();
                salary = scanner.nextInt();
                subject = scanner.nextLine();
                Teachers t1 = scoala.createTeacher(name, surname, age, salary, subject);
                wr.printTeacher(t1);
                insr.AddEmployee(t1);
                audit.WriteToAudit("Teacher info was printed");
            }
            if(command == 3) {
                String name, surname, job;
                int age, salary;
                name = scanner.nextLine();
                surname = scanner.nextLine();
                age = scanner.nextInt();
                salary = scanner.nextInt();
                job = scanner.nextLine();
                AuxiliaryEmployees e1 = scoala.createWorker(name, surname, age, salary, job);
                wr.printAuxiliaryEmployee(e1);
                insr.AddEmployee(e1);
                audit.WriteToAudit("Auxiliary employee info was printed");
            }
            if(command == 4){
                int number, length, width;
                String subject;
                number = scanner.nextInt();
                length = scanner.nextInt();
                width = scanner.nextInt();
                subject = scanner.nextLine();
                Laboratories lab1 = scoala.createLab(number, width, length, subject);
                wr.printLaboratories(lab1);
                insr.AddHall(lab1);
                audit.WriteToAudit("Laboratory info was printed");
            }
            if(command == 5){
                int number, length, width;
                int classnumber;
                char letter;
                number = scanner.nextInt();
                length = scanner.nextInt();
                width = scanner.nextInt();
                classnumber = scanner.nextInt();
                letter = scanner.next().charAt(0);
                Classrooms c1 = scoala.createClass(number, width, length, classnumber, letter);
                wr.printClassrooms(c1);
                insr.AddHall(c1);
                audit.WriteToAudit("Classroom info was printed");
            }
            if(command == 6){
                String type_event;
                int sum;
                type_event = scanner.nextLine();
                sum = scanner.nextInt();
                try{
                    scoala.addEvent(type_event, sum);
                    insr.AddEvent(new Events(type_event, sum));
                    audit.WriteToAudit("Event added");
                }
                catch(InsufficientFundsException e){
                    System.out.println("Ai nevoie de " + e.getAmount());
                }
            }
            if(command == 7){
                int sum;
                sum = scanner.nextInt();
                scoala.updateBudget(sum);
                audit.WriteToAudit("Budget updated");
            }
            if(command == 8){
                System.out.print("Fondul de salarii lunar al scolii este: ");
                System.out.println(scoala.totalWage());
            }
            if(command == 9){
                System.out.println(scoala.NecessaryFunds());
            }
            if(command == 10){
                String nume;
                int id;
                nume = scanner.nextLine();
                id = scanner.nextInt();
                upd.UpdateStudent(nume, id);
                audit.WriteToAudit("A student has been updated");
            }
            if(command == 11) {
                int age, salary, id;
                age = scanner.nextInt();
                salary = scanner.nextInt();
                id = scanner.nextInt();
                upd.UpdateEmployee(age, salary, id);
                audit.WriteToAudit("An employee has been updated");
            }
            if(command == 12){
                int width, length, id;
                width = scanner.nextInt();
                length = scanner.nextInt();
                id = scanner.nextInt();
                upd.UpdateHall(width, length, id);
                audit.WriteToAudit("A hall has been updated");
            }
            if(command == 13){
                int budget, id;
                budget = scanner.nextInt();
                id = scanner.nextInt();
                upd.UpdateEvent(budget, id);
                audit.WriteToAudit("An event has been updated");
            }
            if(command == 14){
                rd.readStudent();
                audit.WriteToAudit("The students have been printed");
            }
            if(command == 15){
                rd.readEmployee();
                audit.WriteToAudit("The employees have been printed");
            }
            if(command == 16){
                rd.readHall();
                audit.WriteToAudit("The halls have been printed");
            }
            if(command == 17){
                rd.readEvent();
                audit.WriteToAudit("The events have been printed");
            }
            if(command == 18){
                int id;
                id = scanner.nextInt();
                dl.deleteStudent(id);
                audit.WriteToAudit("A student has been deleted");
            }
            if(command == 19){
                int id;
                id = scanner.nextInt();
                dl.deleteEmployee(id);
                audit.WriteToAudit("An employee has been deleted");
            }
            if(command == 20){
                int id;
                id = scanner.nextInt();
                dl.deleteHall(id);
                audit.WriteToAudit("A hall has been deleted");
            }
            if(command == 21){
                int id;
                id = scanner.nextInt();
                dl.deleteEvent(id);
                audit.WriteToAudit("An event has been deleted");
            }
            if(command == 22){
                 break;
            }
        }

        conn.close();
        System.out.println("Am inchis conexiunea");

    }


}
