package org.example.ObjectOriented.LinkedList;

public class LeetCode202 {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {
        long fastPointer = n, slowPointer = n;
        do{
            fastPointer = sumSquare(sumSquare(fastPointer));
            slowPointer = sumSquare(slowPointer);
        }while(slowPointer != fastPointer);
        if(slowPointer == 1)
            return true;
        return false;
    }

    public static long sumSquare(long n){
        long result = 0;
            while(n > 0){
                int rem = (int) (n % 10);
                result += rem * rem;
                n = n / 10;
            }
        return result;
    }
}
