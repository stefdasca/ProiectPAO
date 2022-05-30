package com.company.employees;

public class Teachers extends Employees {
    private String subjecttaught;

    public String getSubjecttaught() {
        return subjecttaught;
    }

    public void setSubjecttaught(String subjecttaught) {
        this.subjecttaught = subjecttaught;
    }

    public Teachers(String name, String surname, int age, int salary, String s) {
        this.setName(name);
        this.setSurname(surname);
        this.setAge(age);
        this.setSalary(salary);
        this.subjecttaught = s;
    }
}
