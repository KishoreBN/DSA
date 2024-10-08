package org.example.Sorting.BubbleSort.CyclicSort;

import java.util.ArrayList;
import java.util.List;

public class LeetCode448 {
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(arr));
    }

    static List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        List<Integer> result = new ArrayList<>();
        while(i < nums.length){
            int correctIndex = nums[i] - 1;
            if(correctIndex < nums.length && nums[correctIndex] != nums[i]){
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                i++;
            }
        }
        for (int j=0; j<nums.length; j++){
            if(j+1 != nums[j])
                result.add(j + 1);
        }
        return result;
    }
}
