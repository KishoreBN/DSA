package org.example.Bitwise;

public class LeetCode461 {
    public static void main(String[] args) {
        System.out.println(hammingDistance(3,1));
    }

    static int hammingDistance(int x, int y) {
        int result = x ^ y;
        int count = 0;
        while(result > 0){
            if((result & 1) == 1)
                count++;
            result = result >> 1;
        }
        return count;
    }
}
