package org.example.ObjectOriented.ShallowDeepCopy;

public class Student implements Cloneable{
    private int rollno;
    private String name;
    public Address address;

    @Override
    public String toString() {
        return "Student{" +
                "rollno=" + rollno +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }

    Student(int rollno, String name, Address address){
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student object = (Student) super.clone();
        object.address = (Address) this.address.clone();
        return object;
    }
}
