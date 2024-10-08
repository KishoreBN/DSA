package org.example.Recursion;

public class PalindromPartition {
    public static void main(String[] args) {
        palindromePartition("nitin","");
    }

    static void palindromePartition(String unprocessed, String processed){
        if(unprocessed.isEmpty()){
            if(isPalindrome(processed) && !processed.isEmpty()){
                System.out.println(processed);
            }
            return;
        }
        char ch = unprocessed.charAt(0);
        palindromePartition(unprocessed.substring(1), processed);
        palindromePartition(unprocessed.substring(1), processed + ch);
    }

    static boolean isPalindrome(String str){
        StringBuilder temp = new StringBuilder(str);
        return str.equals(temp.reverse().toString());
    }
}
