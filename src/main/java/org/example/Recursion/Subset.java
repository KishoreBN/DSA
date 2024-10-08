package org.example.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(List.of(1,2,3,4,5));
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        subSet(nums, new ArrayList<>(), result);
        System.out.println(result.size());
        int[] nums2 = {2,1,2};
        System.out.println(subSetWithDuplicates(nums2));
    }

    static void subSet(List<Integer> unprocessed, ArrayList<Integer> processed, List<ArrayList<Integer>> result){
        if(unprocessed.size() == 0){
            result.add(processed);
            return;
        }
        Integer num = unprocessed.get(0);
        ArrayList<Integer> numAdded = new ArrayList(processed);
        numAdded.add(num);
        subSet(unprocessed.subList(1, unprocessed.size()), processed, result);
        subSet(unprocessed.subList(1, unprocessed.size()), numAdded, result);
    }

    static List<ArrayList<Integer>> subSetIteration(int[] nums){
        List<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(Integer i : nums){
            int n = result.size();
            for(int j=0; j < n; j++){
                ArrayList<Integer> internal = new ArrayList<>(result.get(j));
                internal.add(i);
                result.add(internal);
            }
        }
        return result;
    }

    static List<ArrayList<Integer>> subSetWithDuplicates(int[] nums){
        Arrays.sort(nums);
        List<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        int start = 0, end = 0;
        for(int i=0; i<nums.length; i++){
            start = 0;
            if( i > 0 && nums[i] == nums[i-1])
                start = end + 1;
            end = result.size() - 1;
            int n = result.size();
            for(int j=start; j<n; j++){
                ArrayList<Integer> internal = new ArrayList<>(result.get(j));
                internal.add(nums[i]);
                result.add(internal);
            }
        }
        return result;
    }
}
