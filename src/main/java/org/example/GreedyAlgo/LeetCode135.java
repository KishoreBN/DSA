package org.example.GreedyAlgo;

import java.util.Arrays;

public class LeetCode135 {
    public static void main(String[] args) {
        int[] ratings = {1,0,2};
        System.out.println(helper(ratings));
    }

    public static int candy(int[] ratings) {
        int[] leftMin = new int[ratings.length];
        int[] rightMin = new int[ratings.length];
        leftMin[0] = 1;
        rightMin[ratings.length - 1] = 1;
        for(int i=1; i<ratings.length; i++){
            if(ratings[i] > ratings[i - 1])
                leftMin[i] = leftMin[i - 1] + 1;
            else
                leftMin[i] = 1;
        }
        for(int i=ratings.length - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1])
                rightMin[i] = rightMin[i + 1] + 1;
            else
                rightMin[i] = 1;
        }
        int result = 0;
        for (int i=0; i<ratings.length; i++){
            result += Math.max(leftMin[i], rightMin[i]);
        }
        return result;
    }

    public static int helper(int[] ratings){
        int result = 1, n = 1;
        while (n < ratings.length){
            if(ratings[n] == ratings[n - 1]){
                result += 1;
                n++;
                continue;
            }
            int peak = 1;
            while (n < ratings.length && ratings[n] > ratings[n - 1]){
                peak++;
                result += peak;
                n++;
            }
            int down = 1;
            while (n < ratings.length && ratings[n] < ratings[n - 1]){
                result += down;
                down++;
                n++;
            }
            if(down > peak){
                result += (down - peak);
            }
        }
        return result;
    }
}
