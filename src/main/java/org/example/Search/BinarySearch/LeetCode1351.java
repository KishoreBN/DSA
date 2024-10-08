package org.example.Search.BinarySearch;

public class LeetCode1351 {
    public static void main(String[] args) {
        int[][] grid = {
                {4,3,2,-1},
                {3,2,1,-1},
                {1,1,-1,-2},
                {-1,-1,-2,-3}
        };
        System.out.println(countNegatives(grid));
    }

    static int countNegatives(int[][] grid) {
        int start = 0, last = grid[0].length - 1, count = 0;
        while(start < grid.length && last >= 0){
            if(grid[start][last] > -1)
                start++;
            else{
                count = count + (grid.length - start);
                last--;
            }
        }
        return count;
    }
}
