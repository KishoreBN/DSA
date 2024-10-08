package org.example.ObjectOriented.Queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LeetCode1475 {
    public static void main(String[] args) {
        int[] prices = {8,4,6,2,3};
        System.out.println(Arrays.toString(finalPrices(prices)));
    }

    public static int[] finalPrices(int[] prices) {
        Deque<Integer> stack = new LinkedList<>();
        int[] result = new int[prices.length];
        for(int i=prices.length - 1; i >=0 ; i--){
            while (!stack.isEmpty() && stack.peekLast() > prices[i]){
                stack.pollLast();
            }
            result[i] = stack.isEmpty() ? prices[i] : prices[i] - stack.peekLast();
            stack.offerLast(prices[i]);
        }
        return result;
    }
}
