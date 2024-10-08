package org.example.Recursion.LeetCode;

public class GFG02 {
    public static void main(String[] args) {
        int[][] arr = {{1,1,1,1,1,1,1,1,1,1},{1,1,0,1,1,0,1,1,0,1},{1,1,1,1,1,1,1,1,1,1}};
        longestPossiblePath(arr,0,0,0);
        System.out.println(max);
    }

    static int max = 0;

    static void longestPossiblePath(int[][] path, int row, int col, int sum){
        if(sum > max){
            max = sum;
        }
        if(row < 0 || row >= path.length || col < 0 || col >= path[row].length || path[row][col] == 0){
            return;
        }
        path[row][col] = 0;
        sum++;
        longestPossiblePath(path, row + 1, col, sum);
        longestPossiblePath(path, row, col + 1, sum);
        longestPossiblePath(path, row, col - 1, sum);
        longestPossiblePath(path, row - 1, col, sum);
        path[row][col] = 1;
    }
}
