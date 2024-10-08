package org.example.Recursion.LeetCode;

public class LeetCode60 {
    public static void main(String[] args) {
        System.out.println(getPermutation(4,2));
    }

    static int count = 1;

    static String getPermutation(int n, int k) {
        StringBuilder str = new StringBuilder();
        for(int i=1; i<=n; i++){
            str.append(i);
        }
        helper(str.toString(), "", k);
        return "";
    }

    static void helper(String unprocessed, String processed, int k){
        if(unprocessed.length() == 0){
            System.out.println(processed);
            return;
        }
        char ch = unprocessed.charAt(0);
        for(int i=0; i < processed.length() + 1; i++){
            String str = processed.substring(0, i) + ch + processed.substring(i, processed.length());
            helper(unprocessed.substring(1), str, k);
        }
    }
}
