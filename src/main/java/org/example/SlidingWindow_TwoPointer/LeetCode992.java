package org.example.SlidingWindow_TwoPointer;

import java.util.HashMap;

public class LeetCode992 {
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,4};
        System.out.println(subarraysWithKDistinct(nums, 3));
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {
        return subArrayLessThanEqual(nums, k) - subArrayLessThanEqual(nums, k - 1);
    }

    public static int subArrayLessThanEqual(int[] nums, int k){
        if(k < 0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int right = 0, left = 0, count = 0;
        while (right < nums.length){
            if(map.get(nums[right]) == null){
                map.put(nums[right], 1);
            } else {
                map.put(nums[right], map.get(nums[right]) + 1);
            }
            while (map.size() > k){
                if(map.get(nums[left]) == 1)
                    map.remove(nums[left]);
                else
                    map.put(nums[left], map.get(nums[left]) - 1);
                left++;
            }
            count += (right - left + 1);
            right++;
        }
        return count;
    }
}
