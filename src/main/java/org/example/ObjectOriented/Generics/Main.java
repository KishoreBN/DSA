package org.example.ObjectOriented.Generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        //Generic Class
        CustomArrayList<Integer> arr = new CustomArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        Integer[] arr1 = {1,2,3};
        String[] arr2 = {"A","B","X"};
        //Generic method
        System.out.println(Utility.printElements(arr2));
        //Compare objects
        Student one = new Student(1,"Kishore");
        Student two = new Student(2, "XYZ");
    }
}
