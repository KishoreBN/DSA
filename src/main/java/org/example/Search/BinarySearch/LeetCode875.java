package org.example.Search.BinarySearch;

public class LeetCode875 {
    public static void main(String[] args) {
        int[] arr = {30,11,23,4,20};
        int h = 6;
        System.out.println(minEatingSpeed(arr, h));
    }

    static int minEatingSpeed(int[] piles, int h){
        int start = 1, end = Integer.MIN_VALUE, mid = -1;
        //will return the upper bound value
        for(int i =0; i<piles.length; i++){
            if(piles[i] > end)
                end = piles[i];
        }
        while(start < end){
            mid = start + (end - start) / 2;
            int hours = 0;
            for(int i=0; i<piles.length; i++){
                int pileHour = piles[i] / mid;
                if(piles[i] % mid != 0)
                    pileHour++;
                hours = hours + pileHour;
            }
            if(hours <= h){
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
