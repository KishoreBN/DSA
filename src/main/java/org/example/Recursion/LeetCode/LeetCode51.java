package org.example.Recursion.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode51 {
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

    static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[][] arr = new int[n][n];
        helper(0,n,arr, result);
        return result;
    }

    static void helper(int row, int n, int[][] arr, List<List<String>> result){
        if(row >= n){
                addResult(arr, result);
            return;
        }
        for(int i=0; i<n; i++){
            if(!checkQueenPresent(row,i,arr)){
                arr[row][i] = 1;
                helper(row+1, n, arr, result);
                arr[row][i] = 0;
            }
        }
    }

    static void addResult(int[][] arr, List<List<String>> result){
        List<String> internal = new ArrayList<>();
        for(int[] i : arr){
            StringBuilder str = new StringBuilder("");
            for(int j : i){
                if(j == 0)
                    str.append(".");
                else
                    str.append("Q");
            }
            internal.add(str.toString());
        }
        result.add(internal);
    }

    static boolean checkQueenPresent(int row, int col, int[][] arr){
        int tempRow = row, tempCol = col;
        while(tempRow >= 0){
            if(arr[tempRow][tempCol] != 0){
                return true;
            }
            tempRow--;
        }
        tempRow = row;
        while(tempCol >= 0){
            if(arr[tempRow][tempCol] != 0)
                return true;
            tempCol--;
        }
        tempRow = row; tempCol = col;
        while(tempRow >=0 && tempCol >= 0){
            if(arr[tempRow][tempCol] != 0)
                return true;
            tempCol--;
            tempRow--;
        }
        tempRow = row; tempCol = col;
        while(tempRow >= 0 && tempCol < arr.length){
            if(arr[tempRow][tempCol] != 0)
                return true;
            tempCol++;
            tempRow--;
        }
        return false;
    }
}
