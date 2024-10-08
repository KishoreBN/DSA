package org.example.Search.BinarySearch;

public class LeetCode69 {
    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }

    static int mySqrt(int x) {
        if(x == 0 || x ==1)
            return x;
        int start = 0, end = x/2, mid = -1;
        while(start <= end){
            mid = (start + end) / 2;
            long sqrt = (long) mid * mid;
            if(sqrt == x)
                return mid;
            else if(sqrt > x)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return end;
    }
}
