package org.example.SlidingWindow_TwoPointer;

import java.util.HashMap;

public class LeetCode219 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
        System.out.println(containsNearbyDuplicate(nums, 2));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int right = 0, left = 0;
        while (right < nums.length){
            if(map.get(nums[right]) == null)
                map.put(nums[right], 1);
            else
                map.put(nums[right], map.get(nums[right]) + 1);
            if((right - left + 1) > (k + 1)){
                if(map.get(nums[left]) == 1)
                    map.remove(nums[left]);
                else
                    map.put(nums[left], map.get(nums[left]) - 1);
                left++;
            }
            if(map.get(nums[right]) != null && map.get(nums[right]) > 1)
                return true;
            right++;
        }
        return false;
    }
}
