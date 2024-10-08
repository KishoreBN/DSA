package org.example.Bitwise;

public class OddEven {
    public static void main(String[] args) {
        System.out.println(isOdd(4));
    }

    static boolean isOdd(int n){
        return ((n & 1) == 1);
    }
}
