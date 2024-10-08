package org.example.Recursion.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode212 {
    public static void main(String[] args) {
        char[][] board = {{'o','a','b','n'},{'o','t','a','e'},{'a','h','k','r'},{'a','f','l','v'}};
        String[] words = {"oa","oaa"};
        System.out.println(findWords(board, words));
    }

    static List<String> findWords(char[][] board, String[] words) {
        int[][] viisted = new int[board.length][board[0].length];
        List<String> result = new ArrayList<>();
        for(int k=0; k<words.length; k++) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if(board[i][j] == words[k].charAt(0) && !result.contains(words[k]) && helper(board, viisted, words[k], "", i,j)){
                        result.add(words[k]);
                    }
                }
            }
        }
        return result;
    }

    static boolean helper(char[][] board, int[][] visited, String word, String processed, int row, int col){
        if(processed.equals(word)){
            return true;
        }
        if(row < 0 || row >= board.length || col < 0 || col >= board[row].length || visited[row][col] == 1 || !(word.startsWith(processed))){
            return false;
        }
        visited[row][col] = 1;
        if(helper(board, visited, word, processed + board[row][col], row + 1, col)||
        helper(board, visited, word, processed + board[row][col], row , col + 1)||
        helper(board, visited, word, processed + board[row][col], row - 1, col)||
        helper(board, visited, word, processed + board[row][col], row, col - 1)){
            visited[row][col] = 0;
            return true;
        }
        visited[row][col] = 0;
        return false;
    }

}
