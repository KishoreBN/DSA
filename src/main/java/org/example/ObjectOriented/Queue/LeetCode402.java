package org.example.ObjectOriented.Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class LeetCode402 {
    public static void main(String[] args) {
        System.out.println(helper("1432219", 3));
    }

    public static String removeKdigits(String num, int k) {
        Deque<Integer> stack = new LinkedList<>();
        for(char c : num.toCharArray()){
            while (!stack.isEmpty() && stack.peek() > (c - '0') && k > 0){
                stack.pop();
                k--;
            }
            stack.push(c - '0');
        }
        while(!stack.isEmpty() && stack.peekLast()=='0'){
            stack.pollLast();
        }
        while(!stack.isEmpty() && k>0){
            stack.pop();
            k--;
        }
        StringBuilder result=new StringBuilder();
        while(!stack.isEmpty()){
            result.append(stack.pollLast());
        }
        return result.length() == 0 ?"0":result.toString();
    }

    public static String helper(String num, int k){
        Deque<Integer> stack = new LinkedList<>();
        StringBuilder answer = new StringBuilder();
        for(char c : num.toCharArray()){
            while (!stack.isEmpty() && stack.peekLast() > c - '0' && k > 0){
                stack.pollLast();
                k--;
            }
            stack.offerLast(c - '0');
        }
        while (!stack.isEmpty() && k > 0){
            stack.pollLast();
            k--;
        }
        while (!stack.isEmpty() && stack.peekFirst() == 0){
            stack.pollFirst();
        }
        while (!stack.isEmpty()){
            answer.append(stack.pollFirst());
        }
        return answer.toString().equals("") ? "0" : answer.toString();
    }
}
