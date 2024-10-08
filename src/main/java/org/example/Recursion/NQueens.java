package org.example.Recursion;

import java.util.Arrays;

public class NQueens {
    public static void main(String[] args) {
        int[][] arr = new int[4][4];
        nQueens(4,0,arr, 1);
    }

    static void nQueens(int n, int row, int[][] arr, int step){
        if(step > n){
            for(int[] i : arr)
                System.out.println(Arrays.toString(i));
            System.out.println();
            return;
        }
        for(int i = 0; i < n; i++){
            if(!checkQueenPresent(row, i, arr)){
                arr[row][i] = step;
                nQueens(n, row + 1, arr, step+1);
                arr[row][i] = 0;
            }
        }
    }

    static boolean checkQueenPresent(int row, int col, int[][] arr){
        int tempRow = row, tempCol = col;
        while(tempRow >= 0){
            if(arr[tempRow][tempCol] != 0)
                return true;
            tempRow--;
        }
        tempRow = row;
        while(tempRow >= 0 && tempCol >= 0){
            if(arr[tempRow][tempCol] != 0)
                return true;
            tempRow--;
            tempCol--;
        }
        tempRow = row; tempCol = col;
        while (tempRow >= 0 && tempCol < arr.length){
            if(arr[tempRow][tempCol] != 0)
                return true;
            tempRow--;
            tempCol++;
        }
        return false;
    }
}
