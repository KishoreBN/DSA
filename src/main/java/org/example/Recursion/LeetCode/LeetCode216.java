package org.example.Recursion.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode216 {
    public static void main(String[] args) {
        System.out.println(combinationSum3(9,45));
    }

    static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        helper(k,n, new ArrayList<>(),1, result);
        return result;
    }

    static void helper(int k, int n, List<Integer> subset, int index, List<List<Integer>> result){
        if(subset.size() == k && n == 0){
            result.add(new ArrayList<>(subset));
            return;
        }
        if(n < 0 || subset.size() > k){
            return;
        }
        for(int i=index; i<=9; i++){
            subset.add(i);
            helper(k, n - i, subset, i+ 1, result);
            subset.remove(subset.size() - 1);
        }
    }
}
