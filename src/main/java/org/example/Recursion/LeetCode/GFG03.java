package org.example.Recursion.LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
Given a set of n integers, divide the set in two subsets of n/2 sizes each such that the absolute difference
of the sum of two subsets is as minimum as possible. If n is even, then sizes of two subsets must be strictly n/2
and if n is odd, then size of one subset must be (n-1)/2 and size of other subset must be (n+1)/2.
For example, let given set be {3, 4, 5, -3, 100, 1, 89, 54, 23, 20},
the size of set is 10. Output for this set should be {4, 100, 1, 23, 20} and {3, 5, -3, 89, 54}.
Both output subsets are of size 5 and sum of elements in both subsets is same (148 and 148).
Let us consider another example where n is odd. Let given set be {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4}.
The output subsets should be {45, -34, 12, 98, -1} and {23, 0, -99, 4, 189, 4}. The sums of elements in two
subsets are 120 and 121 respectively.
*/
public class GFG03 {
    static int difference = Integer.MAX_VALUE;
    static List<List<Integer>> result = new ArrayList();

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, -3, 100, 1, 89, 54, 23, 20};
        tugOfWar(arr);
        System.out.println(result);
    }

    static void tugOfWar(int[] arr){
        int sum = 0;
        ArrayList<Integer> unprocessed = new ArrayList<>();
        for(int i : arr){
            sum += i;
            unprocessed.add(i);
        }
        helper(unprocessed, new ArrayList<>());
    }

    static void helper(List<Integer> unprocessed, List<Integer> processed){
        if(unprocessed.isEmpty()){
            int dif = Math.abs(arraySum(processed.subList(0, processed.size()/2)) - arraySum(processed.subList(processed.size()/2, processed.size())));
            if (dif < difference) {
                result.clear();
                result.add(new ArrayList<>(processed.subList(0, processed.size()/2)));
                result.add(new ArrayList<>(processed.subList(processed.size()/2, processed.size())));
                difference = dif;
            }
            return;
        }
        int num = unprocessed.get(0);
        for(int i = 0; i < processed.size() + 1; i++){
            ArrayList<Integer> internal = new ArrayList<>(processed);
            internal.add(i, num);
            helper(unprocessed.subList(1, unprocessed.size()), internal);
        }
    }

    static int arraySum(List<Integer> arr){
        int sum = 0;
        for(int i : arr){
            sum += i;
        }
        return sum;
    }
}
