package org.example.Recursion.LeetCode;

public class LeetCode1219 {
    public static void main(String[] args) {
        int[][] arr = {{1,0,7},{2,0,6},{3,4,5},{0,3,0},{9,0,20}};
        System.out.println(getMaximumGold(arr));
    }

    static int max = 0;

    static int getMaximumGold(int[][] grid) {
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                helper(grid, i, j, 0);
            }
        }
        return max;
    }

    static void helper(int[][] grid, int row, int col, int sum){
        if(sum > max){
            max = sum;
        }
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == 0){
            return;
        }
        int currentCellValue = grid[row][col];
        sum += currentCellValue;
        grid[row][col] = 0;
        helper(grid, row + 1, col, sum);
        helper(grid, row, col + 1, sum);
        helper(grid, row - 1, col, sum);
        helper(grid, row, col - 1, sum);
        grid[row][col] = currentCellValue;
    }

}
