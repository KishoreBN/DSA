package org.example.ObjectOriented.ObjectSorting;

import java.util.Comparator;

public class Student implements Comparable<Student> {
    @Override
    public String toString() {
        return "Student{" +
                "rollno=" + rollno +
                ", name='" + name + '\'' +
                '}';
    }
    public int rollno;
    public String name;

    Student(int rollno, String name){
        this.rollno = rollno;
        this.name = name;
    }

    @Override
    public int compareTo(Student o) {
        return this.rollno - o.rollno;
    }
}
