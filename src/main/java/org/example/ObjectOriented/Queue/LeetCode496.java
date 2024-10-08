package org.example.ObjectOriented.Queue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LeetCode496 {
    public static void main(String[] args) {
        int nums1[] = {2,4};
        int nums2[] = {1,2,3,4};
        System.out.println(Arrays.toString(helper(nums1, nums2)));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int result[] = new int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums1.length; i++){
            map.put(nums1[i], i);
        }
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<nums2.length; i++){
            if(!stack.empty() && nums2[i] > stack.peek()){
                while(!stack.empty()){
                    result[map.get(stack.pop())] = nums2[i];
                }
                if(map.containsKey(nums2[i])){
                    stack.push(nums2[i]);
                }
            } else if(map.containsKey(nums2[i])){
                stack.push(nums2[i]);
            }
        }
        while (!stack.empty()){
            result[map.get(stack.pop())] = -1;
        }
        return result;
    }

    public static int[] helper(int[] nums1, int[] nums2){
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            map.put(nums1[i], i);
        }
        for(int i=nums2.length - 1;i>=0;i--){
            while (!stack.empty() && stack.peek() < nums2[i]){
                stack.pop();
            }
            if(map.containsKey(nums2[i])){
                result[map.get(nums2[i])] = stack.empty() ? -1 : stack.peek();
            }
            stack.push(nums2[i]);
        }
        return result;
    }
}
