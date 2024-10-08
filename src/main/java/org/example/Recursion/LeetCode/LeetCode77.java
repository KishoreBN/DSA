package org.example.Recursion.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode77 {
    public static void main(String[] args) {
        System.out.println(combine(1,1));
    }

    static List<List<Integer>> combine(int n, int k) {
        int[] arr = new int[n];
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<n; i++){
            arr[i] = i+1;
        }
        helper(arr,k,0,new ArrayList<>(),result);
        return result;
    }

    static void helper(int[] arr, int k, int index, List<Integer> subset, List<List<Integer>> result){
        if(subset.size() == k){
            result.add(new ArrayList<>(subset));
            return;
        }
        for(int i=index; i<arr.length; i++){
            subset.add(arr[i]);
            helper(arr, k, i+1, subset, result);
            subset.remove(subset.size() - 1);
        }
    }
}
