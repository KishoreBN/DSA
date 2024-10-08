package org.example.ObjectOriented.ShallowDeepCopy;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student std1 = new Student(1,"Kishore", new Address("Ben","KAR"));
        Student std2 = (Student) std1.clone();
        std1.address.state = "AND";
        System.out.println(std1);
        System.out.println(std2);
    }
}
