package org.example.Bitwise;

public class LeetCode868 {
    public static void main(String[] args) {
        System.out.println(binaryGap(13));
    }

    static int binaryGap(int n) {
        int pointer = -1, counter = 0, result = 0;
        while(n > 0){
            if((n & 1) == 1){
                if(pointer == -1){
                    pointer = counter;
                }
                result = (counter - pointer) > result ? (counter - pointer) : result;
                pointer = counter;
            }
            counter++;
            n = n >> 1;
        }
        return result;
    }
}
