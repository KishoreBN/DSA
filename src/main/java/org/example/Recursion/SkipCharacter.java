package org.example.Recursion;

public class SkipCharacter {
    public static void main(String[] args) {
        String str = "abcabs";
        System.out.println(skipA(str));
    }

    static String skipA(String unprocessed){
        if(unprocessed.isEmpty()){
            return "";
        }
        char ch = unprocessed.charAt(0);
        if(ch == 'a')
            return skipA(unprocessed.substring(1));
        else
            return ch + skipA(unprocessed.substring(1));
    }
}
