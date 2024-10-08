package org.example.GreedyAlgo;

import java.util.Arrays;

public class GFG04 {

    public static int minCount = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int[] coins = {5,1};
        minCoins(coins, 0, 0);
        System.out.println(minCount);
    }

    public static void minCoins(int coins[], int M, int sum) {
        // Your code goes here
        Arrays.sort(coins);
        helper(coins, 0, sum, 0);
    }

    public static void helper(int[] coins, int processed, int sum, int count){
        if(processed >= sum){
            if(processed == sum){
                minCount = Math.min(minCount, count);
            }
            return;
        }
        for(int i=0; i < coins.length; i++){
            helper(coins, processed + coins[i], sum, count + 1);
        }
    }
}
