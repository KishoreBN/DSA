package org.example.ObjectOriented.Generics;

import java.util.Comparator;

public class Student implements Comparator<Student> {
    int rollno;
    String name;

    Student(int rollno, String name){
        this.rollno = rollno;
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public String toString(){
        return "Rollno : " + rollno + ", Name : " + name;
    }


    @Override
    public int compare(Student o1, Student o2) {
        return o1.rollno - o2.rollno;
    }
}
