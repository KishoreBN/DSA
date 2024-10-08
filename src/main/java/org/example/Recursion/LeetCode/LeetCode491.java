package org.example.Recursion.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode491 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        System.out.println(findSubsequences(arr));
    }

    static List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        helper(nums, 0, -111, new ArrayList<>(), result);
        List<List<Integer>> results = new ArrayList<>();
        for(List<Integer> i : result){
            results.add(i);
        }
        return results;
    }

    static void helper(int[] nums, int index, int previousNum, List<Integer> processed, Set<List<Integer>> result){
        if(index == nums.length){
            if(processed.size() >= 2){
                result.add(new ArrayList<>(processed));
            }
            return;
        }
        if(processed.size() >= 2){
            result.add(new ArrayList<>(processed));
        }
        for(int i=index; i<nums.length; i++){
            if(nums[i] >= previousNum){
                processed.add(nums[i]);
                helper(nums, i+1, nums[i], processed, result);
                processed.remove(processed.size() - 1);
            }
        }
    }
}
