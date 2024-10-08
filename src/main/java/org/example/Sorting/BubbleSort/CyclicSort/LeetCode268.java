package org.example.Sorting.BubbleSort.CyclicSort;

public class LeetCode268 {
    public static void main(String[] args) {
        int[] arr = {1,2};
        System.out.println(missingNumber(arr));
    }

    static int missingNumber(int[] nums) {
        int i =0;
        while(i < nums.length){
            int correct = nums[i];  //Since the range is from 0 ... N
            if(correct < nums.length && nums[correct] != nums[i]){
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            } else{
                i++;
            }
        }
        for(int j=0; j< nums.length; j++){
            if(j != nums[j])
                return j;
        }
        return nums.length;
    }
}
