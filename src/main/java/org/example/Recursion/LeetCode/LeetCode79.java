package org.example.Recursion.LeetCode;

public class LeetCode79 {
    public static void main(String[] args) {
        char[][] board = {{'A','A','A','A','A','A'},{'A','A','A','A','A','A'},{'A','A','A','A','A','A'},{'A','A','A','A','A','A'},{'A','A','A','A','A','B'},{'A','A','A','A','B','A'}};
        System.out.println(exist(board,"AAAAAAAAAAAAABB"));
    }

    static boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] == word.charAt(0)){
                    boolean result = helperV2(board, 0,0, word, new int[board.length][board[0].length],0);
                    if(result){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static boolean helper(char[][] board, int[][] backtrack, String word, int row, int col, String processed){
        if(processed.contains(word)){
            return true;
        }
        if(backtrack[row][col] == 1){
            return false;
        }
        if((board[row][col] + "").equals(word))
            return true;
        if(processed.length() > word.length()){
            return false;
        }
        if(!processed.equals(word.substring(0, processed.length()))){
            return false;
        }
        backtrack[row][col] = 1;
        boolean left = false, right = false, up = false, down = false;
        if(row + 1 < board.length)
            down = helper(board, backtrack, word, row+1, col, processed + board[row][col]);
        if(!down && col + 1 < board[0].length)
            right = helper(board, backtrack, word, row, col + 1, processed + board[row][col]);
        if(!right && row > 0)
            up = helper(board, backtrack, word,  row -1 , col, processed + board[row][col]);
        if(!up && col > 0)
            left = helper(board, backtrack, word, row, col - 1, processed + board[row][col]);
        backtrack[row][col] = 0;
        return down || right || up || left;
    }

    /*
        Optimized Approach
    */
    static boolean helperV2(char[][] board, int i, int j, String word, int[][] backtrack, int searchLength){
        if(searchLength == word.length()){
            return true;
        }
        if(i<0 || i>=board.length || j<0 || j>=board[i].length || backtrack[i][j] == 1 || board[i][j] != word.charAt(searchLength)){
            return false;
        }
        backtrack[i][j] = 1;
        if(helperV2(board, i+1, j, word, backtrack, searchLength+1)
        || helperV2(board, i, j+1, word, backtrack, searchLength+1)
        || helperV2(board, i-1, j, word, backtrack, searchLength+1)
        || helperV2(board, i, j-1, word, backtrack, searchLength+1)){
            return true;
        }
        backtrack[i][j] = 0;
        return false;
    }
}
