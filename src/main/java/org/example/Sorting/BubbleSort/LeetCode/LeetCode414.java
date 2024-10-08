package org.example.Sorting.BubbleSort.LeetCode;

public class LeetCode414 {
    public static void main(String[] args) {
        int[] arr = {-2147483648, 1, 2, 3};
        System.out.println(thirdMax(arr));
    }

    static int thirdMax(int[] nums) {
        long firstMax = Long.MIN_VALUE, secondMax = Long.MIN_VALUE, thirdMax = Long.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            if(nums[i] >= firstMax){
                if(nums[i] == firstMax)
                    continue;
                long temp = firstMax;
                firstMax = nums[i];
                thirdMax = secondMax;
                secondMax = temp;
            } else if(nums[i] >= secondMax) {
                if(nums[i] == secondMax)
                    continue;
                thirdMax = secondMax;
                secondMax = nums[i];
            } else if(nums[i] >= thirdMax) {
                if(nums[i] == thirdMax)
                    continue;
                thirdMax = nums[i];
            }
        }
        if(thirdMax == Long.MIN_VALUE){
            return (int)firstMax;
        }
        return (int)thirdMax;
    }
}
