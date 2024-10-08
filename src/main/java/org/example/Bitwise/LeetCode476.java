package org.example.Bitwise;

public class LeetCode476 {
    public static void main(String[] args) {
        System.out.println(findComplement(5));
    }

    static int findComplement(int num) {
        int bitsRequired = (int)(Math.log(num) / Math.log(2)) + 1;
        int maxNum = (int)(Math.pow(2, bitsRequired) - 1);
        return num ^ maxNum;
    }
}
