package org.example.Search.BinarySearch;

public class LeetCode1802 {
    public static void main(String[] args) {
        System.out.println(maxValue(1,0,24));
    }
    static int maxValue(int n, int index, int maxSum) {
        int start = 0, last = maxSum, ans = -1;
        while(start <= last){
            int mid = start + (last - start) / 2;
            int totalSum = sumValues(0, index - 1, mid) + mid + sumValues(index + 1, n - 1, mid);
            if(totalSum <= maxSum) {
                ans = mid;
                start = mid + 1;
            }
            else {
                last = mid - 1;
            }
        }
        return ans;
    }

    static int sumValues(int startIndex, int lastIndex, int startValue){
        int sum = 0, i = 1;
        while(startIndex <= lastIndex){
            int value = startValue - i > 0 ? startValue - i : 1;
            sum += value;
            i++;
            startIndex++;
        }
        return sum;
    }
}
