package org.example.ObjectOriented.Queue;

import java.sql.Timestamp;
import java.util.*;

public class LeetCode735 {
    public static void main(String[] args) {
        int[] result = helper2(new int[]{5,10,-5});
        System.out.println(Arrays.toString(result));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i : asteroids){
            if(stack.empty() || (i > 0 && stack.peek() > 0) || (i < 0 && stack.peek() < 0)
            || (i > 0 && stack.peek() < 0)){
                stack.push(i);
            }else if(Math.abs(stack.peek()) == Math.abs(i)){
                stack.pop();
            }else {
                while(!stack.empty() && (Math.abs(i) > Math.abs(stack.peek()))){
                    stack.pop();
                }
                if(stack.empty() || Math.abs(i) >= Math.abs(stack.peek())){
                    stack.push(i);
                }
            }
        }
        int[] result = new int[stack.size()];
        int i=0;
        Collections.reverse(stack);
        while (!stack.empty()){
            result[i++] = stack.pop();
        }
        return result;
    }

    public static int[] helper(int[] asteroids){
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while(i < asteroids.length){
            if(stack.empty() || (asteroids[i] > 0 && stack.peek() > 0) || (asteroids[i] < 0 && stack.peek() < 0)){
                stack.push(asteroids[i]);
                i++;
            } else if((asteroids[i] < 0 && stack.peek() > 0 && Math.abs(asteroids[i]) == Math.abs(stack.peek()))){
                stack.pop();
                i++;
            } else {
                if(stack.peek() < 0 && asteroids[i] > 0){
                    stack.push(asteroids[i]);
                    i++;
                } else if(Math.abs(stack.peek()) > Math.abs(asteroids[i])){
                    i++;
                } else {
                    stack.pop();
                }
            }
        }
        int[] result = new int[stack.size()];
        int j=stack.size() - 1;
        while (!stack.empty()){
            result[j--] = stack.pop();
        }
        return result;
    }

    public static int[] helper2(int[] asteroids){
        Stack<Integer> stack = new Stack<>();
        for(int i : asteroids){
            while(!stack.empty() && i < 0 && stack.peek() > 0){
                int diff = i + stack.peek();
                if(diff < 0){
                    stack.pop();
                } else if (diff > 0) {
                    i = 0;
                } else {
                    i = 0;
                    stack.pop();
                }
            }
            if(i != 0){
                stack.push(i);
            }
        }
        int[] result = new int[stack.size()];
        for(int i=stack.size() - 1; i >= 0 ; i--){
            result[i] = stack.pop();
        }
        return result;
    }
}
