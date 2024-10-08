package org.example.Recursion.LeetCode;

import java.util.Arrays;

public class LeetCode980 {
    static int count = 0;
    public static void main(String[] args) {
        int[][] grid = {{0,1},{2,0}};
        uniquePathsIII(grid);
        System.out.println(count);
    }

    static void uniquePathsIII(int[][] grid) {
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == 1){
                    helper(grid, i, j);
                    break;
                }
            }
        }
    }

    static void helper(int[][] grid, int row, int col){
        if(row >= 0 && row < grid.length && col >= 0 && col < grid[row].length && grid[row][col] == 2){
            if(checkifVisited(grid)){
                count++;
            }
            return;
        }
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == -1 || grid[row][col] == 3){
            return;
        }
        grid[row][col] = 3;
        helper(grid, row + 1, col);
        helper(grid, row, col +1);
        helper(grid, row - 1, col);
        helper(grid, row, col - 1);
        grid[row][col] = 0;
    }

    static boolean checkifVisited(int[][] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                if(arr[i][j] == 0)
                    return false;
            }
        }
        return true;
    }
}
