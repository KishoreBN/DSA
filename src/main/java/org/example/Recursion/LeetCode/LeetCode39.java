package org.example.Recursion.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode39 {
    public static void main(String[] args) {
        int[] nums = {2,3,6,7};
        System.out.println(combinationSum(nums, 7));
    }

    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, target, new ArrayList<>(),0, result);
        return result;
    }

    static void helper(int[] candidates, int target, ArrayList<Integer> subset, int startIndex, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(subset));
            return;
        }
        if(target < 0){
            return;
        }
        for(int i = startIndex; i<candidates.length; i++){
            subset.add(candidates[i]);
            helper(candidates, target - candidates[i], subset,i, result);
            subset.remove(subset.size() - 1);
        }
    }
}
