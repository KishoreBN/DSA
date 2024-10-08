package org.example.Bitwise;

import java.util.Arrays;

public class LeetCode260 {
    public static void main(String[] args) {
        int[] arr = {1,2,1,3,2,5};
        System.out.println(Arrays.toString(singleNumber(arr)));
    }

    static int[] singleNumber(int[] nums) {
        int XORResult = 0;
        int x = 0, y =0;
        for(int i: nums){
            XORResult ^= i;
        }
        int k = log(XORResult & -XORResult, 2);
        for(int i:nums){
            if((i & (1 << k)) != 0){
                x = x ^ i;
            } else {
                y = y ^ i;
            }
        }
        return new int[]{x,y};
    }

    static int log(int x, int base){
        return (int)(Math.log(x)/Math.log(base));
    }
}
