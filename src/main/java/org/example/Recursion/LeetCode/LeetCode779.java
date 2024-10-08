package org.example.Recursion.LeetCode;

public class LeetCode779 {
    public static void main(String[] args) {
        kthGrammar(5,3);
    }

    static void kthGrammar(int n, int k) {
        helper("0",3,1);
    }

    static void helper(String processed, int k, int index){
        if(index == k){
            System.out.println(processed);
            return;
        }
        String nextString = "";
        for(char ch: processed.toCharArray()){
            if(ch == '0')
                nextString += "01";
            else
                nextString += "10";
        }
        helper(nextString, k, index + 1);
    }
}
