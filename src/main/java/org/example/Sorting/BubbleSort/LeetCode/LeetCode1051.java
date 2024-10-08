package org.example.Sorting.BubbleSort.LeetCode;

public class LeetCode1051 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(heightChecker(arr));
    }
    static int heightChecker(int[] heights) {
        int max = Integer.MIN_VALUE;
        for(int i : heights){
            if(i > max)
                max = i;
        }
        int[] frequencyArr = new int[max + 1];
        for(int i : heights){
            frequencyArr[i]++;
        }
        int j = 0, count = 0;
        for(int i=0; i<heights.length; i++){
            while(frequencyArr[j] == 0)
                j++;
            if(j != heights[i])
                count++;
            frequencyArr[j]--;
        }
        return count;
    }
}
