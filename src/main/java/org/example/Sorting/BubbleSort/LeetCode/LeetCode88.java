package org.example.Sorting.BubbleSort.LeetCode;

import java.util.Arrays;

public class LeetCode88 {
    public static void main(String[] args) {
        int[] nums1 = {0};
        int[] nums2 = {1};
        merge(nums1,0,nums2,1);
        System.out.println(Arrays.toString(nums1));
    }

    static void merge(int[] nums1, int m, int[] nums2, int n) {
        int a = m - 1, b = n - 1, c = nums1.length - 1;
        while(a < c && a >= 0 && c >= 0){
            if(nums1[a] < nums2[b]){
                nums1[c] = nums2[b];
                b--;
            } else {
                int temp = nums1[a];
                nums1[a] = nums1[c];
                nums1[c] = temp;
                a--;
            }
            c--;
        }
        while(b >= 0){
            nums1[c] = nums2[b];
            b--;
            c--;
        }
    }
}
