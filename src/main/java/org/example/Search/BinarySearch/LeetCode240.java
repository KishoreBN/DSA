package org.example.Search.BinarySearch;

public class LeetCode240 {
    public static void main(String[] args) {
        int[][] arr = {
                {1,1}
        };
        System.out.println(searchMatrix(arr, 2));
    }

    static boolean searchMatrix(int[][] matrix, int target){
        int row = 0, column = matrix[0].length - 1;
        while (column >=0 && (row < matrix.length) ){
            if(matrix[row][column] == target)
                return true;
            else if(matrix[row][column] > target)
                column--;
            else
                row++;
        }
        return false;
    }
}
