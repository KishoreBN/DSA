package org.example.Bitwise;

public class LeetCode693 {
    public static void main(String[] args) {
        System.out.println(hasAlternatingBits(3));
    }

    static boolean hasAlternatingBits(int n) {
        int start = (n & 1);
        int end = 0;
        n = n >> 1;
        while(n > 0){
            end = (n & 1);
            if((start ^ end) != 1)
                return false;
            n = n >> 1;
            start = end;
        }
        return true;
    }
}
