package org.example.ObjectOriented.Queue;

import java.util.*;

public class LeetCode239 {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dequeNumber = new LinkedList<>();
        Deque<Integer> dequeIndex = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        int j = 0;
        for(int i=0; i<nums.length; i++){
            while(!dequeIndex.isEmpty() && dequeIndex.peekFirst() < (i - k + 1)){
                dequeIndex.pollFirst();
                dequeNumber.pollFirst();
            }
            while (!dequeNumber.isEmpty() && dequeNumber.peekLast() < nums[i]){
                dequeIndex.pollLast();
                dequeNumber.pollLast();
            }
            dequeIndex.addLast(i);
            dequeNumber.addLast(nums[i]);
            if(i >= k - 1) {
                result[j++] = dequeNumber.peekFirst();
            }
        }
        return result;
    }
}
