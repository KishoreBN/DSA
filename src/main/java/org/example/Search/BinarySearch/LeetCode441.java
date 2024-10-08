package org.example.Search.BinarySearch;

public class LeetCode441 {
    public static void main(String[] args) {
        System.out.println(arrangeCoins(1804289383));
    }
    static int arrangeCoins(int n){
        int start = 0, last = n;
        while(start <= last){
            int mid = start + (last - start) / 2;
            long expressionRes = ((long)(mid) * (2 + (mid - 1)))/2;
            if(expressionRes == n)
                return mid;
            else if(expressionRes <= n){
                start = mid + 1;
            } else{
                last = mid - 1;
            }
        }
        return start - 1;
    }
}
