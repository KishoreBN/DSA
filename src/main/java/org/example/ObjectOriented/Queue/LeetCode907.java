package org.example.ObjectOriented.Queue;

import java.util.Stack;

public class LeetCode907 {
    public static void main(String[] args) {
        int[] arr = {71,55,82,55};
        System.out.println(sumSubarrayMins(arr));
    }

    public static int sumSubarrayMins(int[] arr) {
        int[] nse = new int[arr.length];
        int[] pse = new int[arr.length];
        Stack<Integer> pseStack = new Stack<>();
        Stack<Integer> nseStack = new Stack<>();
        long result = 0, mod = (int) (1e9 + 7);
        for(int i=arr.length -1; i>=0 ; i--){
            while(!nseStack.empty() && arr[nseStack.peek()] >= arr[i]){
                nseStack.pop();
            }
            nse[i] = nseStack.empty() ? arr.length : nseStack.peek();
            nseStack.push(i);
        }
        for(int i=0; i<arr.length; i++){
            while(!pseStack.empty() && arr[pseStack.peek()] > arr[i]){
                pseStack.pop();
            }
            pse[i] = pseStack.empty() ? -1 : pseStack.peek();
            result += (long)((nse[i] - i) * (i - pse[i])) % mod * arr[i] % mod;
            result %= mod;
            pseStack.push(i);
        }
        return (int)result;
    }
}
