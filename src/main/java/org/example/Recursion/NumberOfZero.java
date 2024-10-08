package org.example.Recursion;

public class NumberOfZero {
    public static void main(String[] args) {
        System.out.println(numberOfZeros(324));
    }

    static int numberOfZeros(int num){
        int count = 0;
        return helper(num, count);
    }

    static int helper(int num, int count){
        if(num == 0){
            return count;
        }
        if(num % 10 == 0)
            count++;
        return helper(num/10, count);
    }
}
