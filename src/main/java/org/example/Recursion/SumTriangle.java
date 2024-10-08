package org.example.Recursion;

import java.util.Arrays;

public class SumTriangle {
    public static void main(String[] args) {
        int[] arr = {1,3,2,4};
        sumTriangle(arr);
        char[] s = {'h','e','l','l','o'};
        reverseString(s,0,s.length - 1);
        System.out.println();
    }

    static void sumTriangle(int[] nums){
        if(nums.length == 1) {
            System.out.println(Arrays.toString(nums));
            return;
        }
        int[] arr = new int[nums.length - 1];
        int j = 0;
        for(int i=0; i<nums.length-1; i++){
            arr[j] = nums[i] + nums[i+1];
            j++;
        }
        sumTriangle(arr);
        System.out.println(Arrays.toString(nums));
    }

    static void reverseString(char[] s, int startIndex, int endIndex){
        if(startIndex >= endIndex){
            return;
        }
        char temp = s[startIndex];
        s[startIndex] = s[endIndex];
        s[endIndex] = temp;
        reverseString(s, startIndex+1, endIndex-1);
    }
}
