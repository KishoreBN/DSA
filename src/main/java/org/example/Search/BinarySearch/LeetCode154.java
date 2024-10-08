package org.example.Search.BinarySearch;

public class LeetCode154 {
    public static void main(String[] args) {
        int[] nums = {
                3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,1,2,3
        };
        System.out.println(findPivotWithDuplicates(nums));
    }

    static int findPivotWithDuplicates(int[] nums){
        int startIndex=0, lastIndex = nums.length - 1;
        while(startIndex < lastIndex){
            int mid = startIndex + (lastIndex - startIndex) /2 ;
            if(mid < lastIndex && nums[mid] > nums[mid + 1])
                return nums[mid + 1];
            else if(mid > startIndex && nums[mid - 1] > nums[mid])
                return nums[mid];
            else if(nums[startIndex]== nums[mid] && nums[mid] == nums[lastIndex]){
                if(nums[startIndex] > nums[startIndex + 1])
                    return nums[startIndex + 1];
                startIndex++;
                if(nums[lastIndex] < nums[lastIndex - 1])
                    return nums[lastIndex];
                lastIndex--;
            }
            else if(nums[startIndex] < nums[mid] || (nums[startIndex] == nums[mid] && nums[mid] > nums[lastIndex]))
                startIndex = mid + 1;
            else
                lastIndex = mid - 1;
        }
        return nums[0];
    }
}
