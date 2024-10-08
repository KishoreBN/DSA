package org.example.Recursion.LeetCode;

public class LeetCode1922 {
    public static void main(String[] args) {
        System.out.println((int)countGoodNumbers(1));
    }

    static long countGoodNumbers(long n) {
        if(n==0){
            return 1;
        }
        if(n%2 == 0)
            return (long)5 * (countGoodNumbers(n-1)) % (long)(Math.pow(10,9) + 7);
        else
            return (long)4 * (countGoodNumbers(n-1)) % (long)(Math.pow(10,9) + 7);
    }
}
