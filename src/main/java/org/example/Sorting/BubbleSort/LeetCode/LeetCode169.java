package org.example.Sorting.BubbleSort.LeetCode;

public class LeetCode169 {
    public static void main(String[] args) {
        int[] nums = {2,2,3};
        System.out.println(majorityElement(nums));
    }

    static int majorityElement(int[] nums) {
        int number = nums[0], count = 1, i = 1;
        while(i < nums.length){
            if(nums[i] != number)
                count--;
            else
                count++;
            if(count == 0){
                number = nums[i];
                count = 1;
            }
            i++;
        }
        return number;
    }
}
