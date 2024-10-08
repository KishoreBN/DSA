package org.example.Recursion.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode486 {
    public static void main(String[] args) {
        int[] arr = {2,4,55,6,8};
        System.out.println(predictTheWinner(arr));
    }

    static boolean predictTheWinner(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        for(int i : nums){
            arr.add(i);
        }
        return helper(arr, 0 ,0);
    }

    static boolean helper(List<Integer> arr, int player1Sum, int player2Sum){
        if(arr.size() == 0){
            if(player1Sum >= player2Sum)
                return true;
            else
                return false;
        }
        List<Integer> temp = new ArrayList<>(arr);
        int firstPossibility = player1Sum + arr.get(0);
        int secondPossibility = player2Sum;
        arr.remove(0);
        if(arr.size() > 0){
            if(arr.get(0) > arr.get(arr.size() - 1)){
                secondPossibility = player2Sum + arr.get(0);
                arr.remove(0);
            } else {
                secondPossibility = player2Sum +  arr.get(arr.size() - 1);
                arr.remove(arr.size() - 1);
            }
        }
        if(helper(arr, firstPossibility, secondPossibility)){
            return true;
        } else {
            firstPossibility = player1Sum + temp.get(temp.size() - 1);
            secondPossibility = player2Sum;
            temp.remove(temp.size() - 1);
            if(temp.size() > 0){
                if(temp.get(0) > temp.get(temp.size() - 1)){
                    secondPossibility = player2Sum + temp.get(0);
                    temp.remove(0);
                } else {
                    secondPossibility = player2Sum + temp.get(temp.size() - 1);
                    temp.remove(temp.size() - 1);
                }
            }
            return helper(temp, firstPossibility, secondPossibility);
        }
    }
}
