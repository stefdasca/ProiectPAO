package com.company.employees;

public class AuxiliaryEmployees extends Employees {
    private String job;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public AuxiliaryEmployees(String name, String surname, int age, int salary, String s) {
        this.setName(name);
        this.setSurname(surname);
        this.setAge(age);
        this.setSalary(salary);
        this.job = s;
    }
}
