package org.example.Sorting.BubbleSort.CyclicSort;

public class LeetCode41 {
    public static void main(String[] args) {
        int[] arr = {-1};
        System.out.println(firstMissingPositive(arr));
    }

    static int firstMissingPositive(int[] nums){
        int i = 0;
        while(i < nums.length){
            int correctIndex = nums[i] - 1;
            if(correctIndex < nums.length && correctIndex >= 0 && nums[i] != nums[correctIndex]){
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                i++;
            }
        }
        for(int j=0; j<nums.length; j++){
            if(j+1 != nums[j])
                if(j == 0)
                    return 1;
                else
                    return j+1;
        }
        return nums[nums.length - 1] + 1;
    }
}
