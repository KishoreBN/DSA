package org.example.Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class CountingPaths {
    public static void main(String[] args) {
        ArrayList<String> result = new ArrayList<>();
//        countingPathWithDiagonal(0,0, "", 2,2, result);
//        System.out.println(result);
        boolean[][] obstacles = {{true, true, true},{true, true, true},{true, true, true}};
        int[][] arr = new int[obstacles.length][obstacles[0].length];
        printPaths(0,0,obstacles,arr,2,2,1);
//        countingAllPaths(0,0,"",2,2,obstacles);
    }


    /*
        Without Diagonal movements allowed.
    */
    static void countingPaths(int row, int col, String path, int targetRow, int targetCol, ArrayList<String> result){
        if(row == targetRow && col == targetCol){
            result.add(path);
            return;
        }
        int nextRow = row + 1;
        int nextCol = col + 1;
        if(nextRow <= targetRow){
            countingPaths(nextRow, col, path + 'D', targetRow, targetCol, result);
        }
        if(nextCol <= targetCol){
            countingPaths(row, nextCol, path + 'R', targetRow, targetCol, result);
        }
    }

    /*
        With Diagonal movements allowed.
    */
    static void countingPathWithDiagonal(int row, int col, String path, int targetRow, int targetCol, ArrayList<String> result){
        if(row==targetRow && col == targetCol){
            result.add(path);
            return;
        }
        int nextRow = row + 1;
        int nextCol = col + 1;
        if(nextRow <= targetRow){
            countingPathWithDiagonal(nextRow, col, path + 'D', targetRow, targetCol, result);
        }
        if(nextCol <= targetCol){
            countingPathWithDiagonal(row, nextCol, path + 'R', targetRow, targetCol, result);
        }
        if(nextRow <= targetRow && nextCol <= targetCol){
            countingPathWithDiagonal(nextRow, nextCol, path + 'Z', targetRow, targetCol, result);
        }
    }

    static void countingPathsWithObstacle(int row, int col, String path, int targetRow, int targetCol, boolean[][] obstacles){
        if(row == targetRow && col == targetCol){
            System.out.println(path);
            return;
        }
        if(obstacles[row][col] == false){
            return;
        }
        int nextRow = row + 1;
        int nextCol = col + 1;
        if(nextRow <= targetRow)
            countingPathsWithObstacle(nextRow, col, path + 'D', targetRow, targetCol, obstacles);
        if(nextCol <= targetCol)
            countingPathsWithObstacle(row, nextCol, path + 'R', targetRow, targetCol, obstacles);
    }

    static void countingAllPaths(int row, int col, String path, int targetRow, int targetCol, boolean[][] visited){
        if(row == targetRow && col == targetCol){
            System.out.println(path);
            return;
        }
        if(visited[row][col] == false)
            return;
        visited[row][col] = false;
        if(row + 1 <= targetRow)
            countingAllPaths(row+1, col, path + 'D', targetRow, targetCol, visited);
        if(col + 1 <= targetCol)
            countingAllPaths(row, col + 1, path + 'R', targetRow, targetCol, visited);
        if(row > 0)
            countingAllPaths(row - 1, col, path + 'U', targetRow, targetCol, visited);
        if(col > 0)
            countingAllPaths(row, col - 1, path + 'L', targetRow, targetCol, visited);
        visited[row][col] = true;
    }

    static void printPaths(int row, int col, boolean[][] visited, int[][] arr, int targetRow, int targetCol, int step){
        if(row == targetRow && col == targetCol){
            arr[row][col] = step;
            for(int[] i : arr){
                System.out.println(Arrays.toString(i));
            }
            System.out.println();
            return;
        }
        if(visited[row][col] == false)
            return;
        arr[row][col] = step;
        visited[row][col] = false;
        if(row + 1 <= targetRow)
            printPaths(row+1, col, visited, arr, targetRow, targetCol, step + 1);
        if(col + 1 <= targetCol)
            printPaths(row, col+1, visited, arr, targetRow, targetCol, step + 1);
        if(row > 0)
            printPaths(row - 1, col, visited, arr, targetRow, targetCol, step + 1);
        if(col > 0)
            printPaths(row, col - 1, visited, arr, targetRow, targetCol, step + 1);
        visited[row][col] = true;
        arr[row][col] = 0;
    }

}
