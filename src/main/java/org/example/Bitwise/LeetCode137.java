package org.example.Bitwise;

public class LeetCode137 {
    public static void main(String[] args) {
        int[] nums = {2,2,-1,2};
        System.out.println(singleNumber(nums));
    }

    static int singleNumber(int[] nums) {
        int result = 0;
        for(int i=0; i<32; i++){
            int count = 0;
            for(int j=0; j<nums.length; j++){
                if(((nums[j] >> i) & 1) == 1)
                    count++;
            }
            result = result | ((count % 3) << i);
        }
        return result;
    }
}
