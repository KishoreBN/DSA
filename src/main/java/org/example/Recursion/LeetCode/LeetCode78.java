package org.example.Recursion.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode78 {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(subsets(arr));
    }

    static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        for(int i : nums){
            arr.add(i);
        }
        helper(arr, new ArrayList<>(), result);
        return result;
    }

    static void helper(List<Integer> unprocessed, List<Integer> processed, List<List<Integer>> result){
        if(unprocessed.size() == 0){
            result.add(new ArrayList<>(processed));
            return;
        }
        helper(unprocessed.subList(1, unprocessed.size()), processed, result);
        processed.add(unprocessed.get(0));
        helper(unprocessed.subList(1, unprocessed.size()), processed, result);
        processed.remove(processed.size() - 1);
    }
}
