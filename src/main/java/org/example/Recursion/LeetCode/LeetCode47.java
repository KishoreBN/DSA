package org.example.Recursion.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode47 {
    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1,1,2}));
    }

    static List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> unprocessed = new ArrayList<>();
        Set<List<Integer>> result = new HashSet<>();
        for(int i : nums){
            unprocessed.add(i);
        }
        helper(unprocessed, new ArrayList<>(), result);
        return new ArrayList<>(result);
    }

    static void helper(List<Integer> unprocessed, List<Integer> processed, Set<List<Integer>> result){
        if(unprocessed.isEmpty()){
            result.add(new ArrayList<>(processed));
            return;
        }
        int num = unprocessed.get(0);
        for(int i=0; i<processed.size() + 1; i++){
            processed.add(i, num);
            helper(unprocessed.subList(1, unprocessed.size()), processed, result);
            processed.remove(i);
        }
    }
}
