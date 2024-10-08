package org.example.Recursion.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode40 {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        System.out.println(combinationSum2(candidates, 8));
    }

    static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        helper2(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    static void helper2(int[] candidates, int target, int index, List<Integer> subset, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(subset));
            return;
        }
        if(target < 0 || index >= candidates.length)
            return;
        int previousNumber = -1;
        for(int i=index; i<candidates.length; i++){
            if(!(candidates[i] == previousNumber)) {
                subset.add(candidates[i]);
                helper2(candidates, target - candidates[i], i + 1, subset, result);
                subset.remove(subset.size() - 1);
            }
            previousNumber = candidates[i];
        }
    }
}
