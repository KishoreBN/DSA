package org.example.Recursion.LeetCode;

import java.util.*;

public class LeetCode90 {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(subsetsWithDup2(nums));
    }

    static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), result);
        return result;
    }

    static void helper(int[] nums, int index, List<Integer> subset, List<List<Integer>> result){
        result.add(new ArrayList<>(subset));
        for(int i=index; i<nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            subset.add(nums[i]);
            helper(nums, index + 1, subset, result);
            subset.remove(subset.size() - 1);
        }
    }

    static List<List<Integer>> subsetsWithDup2(final int[] nums) {
        final List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        backtrack(nums, 0, new ArrayList<>(), res);

        return res;
    }

    static void backtrack(final int[] nums, final int idx, final List<Integer> curr, final List<List<Integer>> res) {
        res.add(new ArrayList<>(curr));

        for(int i = idx; i < nums.length; ++i) {
            if(i != idx && nums[i - 1] == nums[i])
                continue;

            curr.add(nums[i]);
            backtrack(nums, i + 1, curr, res);
            curr.remove(curr.size() - 1);
        }
    }

}
