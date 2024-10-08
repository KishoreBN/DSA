package org.example.ObjectOriented.Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LeetCode2104 {
    public static void main(String[] args) {
        int[] nums = {1,3,3};
        System.out.println(subArrayRanges(nums));
    }

    public static long subArrayRanges(int[] nums) {
        Deque<Integer> pseStack = new ArrayDeque<>();
        Deque<Integer> nseStack = new ArrayDeque<>();
        Deque<Integer> ngeStack = new ArrayDeque<>();
        Deque<Integer> pgeStack = new ArrayDeque<>();
        int[] nse = new int[nums.length];
        int[] pse = new int[nums.length];
        int[] nge = new int[nums.length];
        int[] pge = new int[nums.length];
        long resultMin = 0, resultMax = 0, mod = (int) (1e9 + 7);
        for(int i=nums.length - 1; i >= 0 ; i--){
            while(!nseStack.isEmpty() && nums[nseStack.peek()] >= nums[i]){
                nseStack.pop();
            }
            while(!ngeStack.isEmpty() && nums[ngeStack.peek()] <= nums[i]){
                ngeStack.pop();
            }
            nge[i] = ngeStack.isEmpty() ? nums.length : ngeStack.peek();
            nse[i] = nseStack.isEmpty() ? nums.length : nseStack.peek();
            nseStack.push(i);
            ngeStack.push(i);
        }
        for(int i=0; i<nums.length; i++){
            while (!pseStack.isEmpty() && nums[pseStack.peek()] > nums[i]){
                pseStack.pop();
            }
            while (!pgeStack.isEmpty() && nums[pgeStack.peek()] < nums[i]){
                pgeStack.pop();
            }
            pge[i] = pgeStack.isEmpty() ? -1 : pgeStack.peek();
            pse[i] = pseStack.isEmpty() ? -1 : pseStack.peek();
            resultMin += (long)((nse[i] - i) * (i - pse[i])) * nums[i];
            resultMax += (long)((nge[i] - i) * (i - pge[i])) * nums[i];
            pseStack.push(i);
            pgeStack.push(i);
        }
        return (resultMax - resultMin);
    }

    public static int subArrayMinumum(int[] nums){
        Deque<Integer> pseStack = new ArrayDeque<>();
        Deque<Integer> nseStack = new ArrayDeque<>();
        Deque<Integer> ngeStack = new ArrayDeque<>();
        Deque<Integer> pgeStack = new ArrayDeque<>();
        int[] nse = new int[nums.length];
        int[] pse = new int[nums.length];
        int[] nge = new int[nums.length];
        int[] pge = new int[nums.length];
        long resultMin = 0, resultMax = 0, mod = (int) (1e9 + 7);
        for(int i=nums.length - 1; i >= 0 ; i--){
            while(!nseStack.isEmpty() && nseStack.peek() >= nums[i]){
                nseStack.pop();
            }
            while(!ngeStack.isEmpty() && ngeStack.peek() <= nums[i]){
                ngeStack.pop();
            }
            nge[i] = ngeStack.isEmpty() ? nums.length : ngeStack.peek();
            nse[i] = nseStack.isEmpty() ? nums.length : nseStack.peek();
            nseStack.push(i);
        }
        for(int i=0; i<nums.length; i++){
            while (!pseStack.isEmpty() && pseStack.peek() > nums[i]){
                pseStack.pop();
            }
            while (!pgeStack.isEmpty() && pgeStack.peek() < nums[i]){
                pgeStack.pop();
            }
            pge[i] = pgeStack.isEmpty() ? -1 : pgeStack.peek();
            pse[i] = pseStack.isEmpty() ? -1 : pseStack.peek();
            resultMin += (long)((nse[i] - i) * (i - pse[i])) % mod * nums[i] % mod;
            resultMin %= mod;
            resultMax += (long)((nge[i] - i) * (i - nge[i])) % mod * nums[i] % mod;
            resultMax %= mod;
            pseStack.push(i);
        }
        return (int) (resultMax - resultMin);
    }

}
