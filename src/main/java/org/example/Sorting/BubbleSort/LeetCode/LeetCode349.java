package org.example.Sorting.BubbleSort.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeetCode349 {
    public static void main(String[] args) {
        int[] nums1 = {9,4,9,8,4};
        int[] nums2 = {4,9,5};
        intersection(nums1, nums2);
    }
    static void intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        System.out.println(Arrays.toString(findCommon(nums1, nums2)));
    }

    static int[] findCommon(int[] nums1, int[] nums2){
        List<Integer> result = new ArrayList<>();
        int ptr1 = 0, ptr2 = 0, previouslyAdded = -1;
        while ((ptr1 < nums1.length) && (ptr2 < nums2.length)){
            if(nums1[ptr1] == nums2[ptr2] && nums1[ptr1] != previouslyAdded){
                result.add(nums1[ptr1]);
                previouslyAdded = nums1[ptr1];
                ptr1++;
                ptr2++;
            } else if(nums1[ptr1] > nums2[ptr2]){
                ptr2++;
            } else {
                ptr1++;
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
