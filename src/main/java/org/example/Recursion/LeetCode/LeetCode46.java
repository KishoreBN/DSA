package org.example.Recursion.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode46 {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1}));
    }

    static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> unprocessed = new ArrayList<>();
        for(int i : nums){
            unprocessed.add(i);
        }
        helper(unprocessed, new ArrayList<>(), result);
        return result;
    }

    static void helper(List<Integer> unprocessed, List<Integer> processed, List<List<Integer>> result){
        if(unprocessed.isEmpty()){
            result.add(new ArrayList<>(processed));
            return;
        }
        int num = unprocessed.get(0);
        for(int i=0; i< processed.size() + 1; i++){
            processed.add(i, num);
            helper(unprocessed.subList(1, unprocessed.size()), processed, result);
            processed.remove(i);
        }
    }
}
