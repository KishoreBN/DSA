package org.example.Recursion.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1823 {
    public static void main(String[] args) {
        System.out.println(findTheWinner(5,2));
    }

    static int findTheWinner(int n, int k) {
        List<Integer> arr = new ArrayList<>();
        for(int i=1; i<=n; i++){
            arr.add(i);
        }
        return helper(arr,0,k);
    }

    static int helper(List<Integer> arr,int index, int k){
        if(arr.size() == 1){
            return arr.get(0);
        }
        int remIndex = (index + (k-1)) % arr.size();
        arr.remove(remIndex);
        int nextIndex = (remIndex) % arr.size();
        return helper(arr, nextIndex, k);
    }
}
