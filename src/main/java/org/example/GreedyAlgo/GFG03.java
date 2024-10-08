package org.example.GreedyAlgo;

import java.util.Arrays;
import java.util.Map;

public class GFG03 {
    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(findPlatform(arr, dep));
    }

    public static int findPlatform(int arr[], int dep[]) {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        int arrival = 0, departure = 0, maxCount = Integer.MIN_VALUE, count = 0;
        while (arrival < arr.length && departure < dep.length){
            if(arr[arrival] <= dep[departure]) {
                count++;
                arrival++;
            }
            else {
                count--;
                departure++;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
