package com.company.employees;

public class Employees {
    private String name, surname;
    private int age;
    private int salary;

    public Employees() {

    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public void setName(String Name) {
        name = Name;
    }

    public void setSurname(String Surname) {
        surname = Surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void updateSalary(int amount){
        salary += amount;
    }
}
