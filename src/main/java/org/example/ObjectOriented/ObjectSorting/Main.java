package org.example.ObjectOriented.ObjectSorting;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Student one = new Student(2, "Kishore");
        Student two = new Student(1, "Aahul");
        Student three = new Student(3, "Virat");
        Student[] arr = {one, two, three};
        Arrays.sort(arr, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        System.out.println(Arrays.toString(arr));
    }
}
