package org.example.Recursion;

public class SkipString {
    public static void main(String[] args) {
        String str = "abcbbabby";
        System.out.println(skipString(str));
    }

    static String skipString(String str){
        if(str.isEmpty()){
            return "";
        }
        char ch = str.charAt(0);
        if(str.startsWith("ab") && str.startsWith("abby"))
            return skipString(str.substring(4));
        else
            return ch + skipString(str.substring(1));
    }
}
