package org.example.ObjectOriented.Queue;

import java.util.Stack;

/**
 * Alexa has two stacks of non-negative integers, stack  and stack  where index  denotes the top of the stack. Alexa challenges Nick to play the following game:
 *
 * In each move, Nick can remove one integer from the top of either stack  or stack .
 * Nick keeps a running sum of the integers he removes from the two stacks.
 * Nick is disqualified from the game if, at any point, his running sum becomes greater than some integer  given at the beginning of the game.
 * Nick's final score is the total number of integers he has removed from the two stacks.
 * Given , , and  for  games, find the maximum possible score Nick can achieve.
 *
 * Example
 *
 *
 * The maximum number of values Nick can remove is . There are two sets of choices with this result.
 *
 * Remove  from  with a sum of .
 * Remove  from  and  from  with a sum of .
 */
public class HackerRank01 {
    static int maxScore = 0;
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(6);
        stack.push(4);
        stack.push(2);
        stack.push(4);
        Stack<Integer> second = new Stack<>();
        second.push(5);
        second.push(8);
        second.push(1);
        second.push(2);
        findScore(stack, second, 10);

        System.out.println(maxScore);
    }

    public static void findScore(Stack<Integer> first, Stack<Integer> second, int maxSum){
        helper(first, second, 0, 0, maxSum, "");
    }

    public static void helper(Stack<Integer> first, Stack<Integer> second, int score, int processed, int maxSum, String str){
        if(score > maxScore){
            maxScore = score;
        }
        Integer temp = first.pop();
        if(processed + temp <= maxSum){
            helper(first, second, score + 1, processed + temp, maxSum, str + " " + temp);
        }
        first.push(temp);
        temp = second.pop();
        if(processed + temp <= maxSum){
            helper(first, second, score + 1, processed + temp, maxSum, str + " " + temp);
        }
        second.push(temp);
    }
}
