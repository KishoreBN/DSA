package org.example.ObjectOriented.Queue;

import java.util.Stack;

class StockSpanner {
    Stack<Integer> stackIndex;
    Stack<Integer> stackNumber;
    int size;
    public StockSpanner() {
        stackIndex = new Stack<>();
        stackNumber = new Stack<>();
        size = 0;
    }

    public int next(int price) {
        while (!stackNumber.empty() && stackNumber.peek() <= price){
            stackNumber.pop();
            stackIndex.pop();
        }
        int pge = stackIndex.empty() ? -1 : stackIndex.peek();
        stackNumber.push(price);
        stackIndex.push(size++);
        return (size - 1 - pge);
    }
}
public class LeetCode901 {
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(28));
        System.out.println(stockSpanner.next(14));
        System.out.println(stockSpanner.next(28));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));
    }
}
