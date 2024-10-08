package org.example.Recursion;

public class RemoveRecursive {
    public static void main(String[] args) {
        removeRecursive("geeksforgeeks", "");
    }

    static void removeRecursive(String unprocessed, String processed){
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }
        char ch = unprocessed.charAt(0);
        if(processed.isEmpty() || !(ch == processed.charAt(processed.length() - 1))){
            removeRecursive(unprocessed.substring(1), processed + ch);
        } else {
            removeRecursive(unprocessed.substring(1), processed);
        }
    }
}
