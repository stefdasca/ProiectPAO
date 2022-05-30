package com.company.halls;

public class Laboratories extends Halls{
    private String subject;

    public Laboratories(int number, int width, int length, String subject) {
        this.setRoomnumber(number);
        this.setLength(length);
        this.setWidth(width);
        this.subject = subject;
    }


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
