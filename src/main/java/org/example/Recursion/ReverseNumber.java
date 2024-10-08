package org.example.Recursion;

public class ReverseNumber {
    static int number = 0;
    public static void main(String[] args) {
      System.out.println(reverse(543221));
    }
    static int reverse(int num){
        int digits  = (int) Math.log10(num) + 1;
        return helper(num, digits - 1);
    }

    static int helper(int num, int digits){
        if(num % 10 == 0)
            return num;
        return (int)((num % 10) * Math.pow(10, digits)) + helper(num/10, digits - 1);
    }
}
