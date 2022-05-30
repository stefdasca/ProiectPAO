package com.company.halls;

import com.company.halls.Halls;

public class Classrooms extends Halls {
    private int classnumber;
    private char letter;

    public Classrooms(int number, int width, int length, int classnumber, char letter) {
        this.setRoomnumber(number);
        this.setWidth(width);
        this.setLength(length);
        this.classnumber = classnumber;
        this.letter = letter;
    }

    public int getClassnumber() {
        return classnumber;
    }

    public void setClassnumber(int classnumber) {
        this.classnumber = classnumber;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }
}
