package org.example;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        int[] arr = new int[5];
        System.out.println(Arrays.toString(arr));
        Object[] arr2 = {1, "Array", 12.34};
        System.out.println(Arrays.toString(arr2));
        String[] arr3 = new String[5];
        System.out.println(Arrays.toString(arr3));
        Integer[] arr4 = new Integer[5];
        System.out.println(Arrays.toString(arr4));
    }
}
