package org.example.Recursion.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode93 {
    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("101023"));
    }

    static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        helper(s, "", 3, result);
        return result;
    }

    static void helper(String unprocessed, String processed, int count, List<String> result){
        if(count == 0){
            processed += unprocessed;
            if(!(unprocessed.startsWith("0") && unprocessed.length() > 1) && !(Long.parseLong(unprocessed) > 255)){
                result.add(processed);
            }
            return;
        }
        int i=1;
        while(i<=3 && (i<=unprocessed.length() - 1)){
            String str = unprocessed.substring(0,i);
            if((str.startsWith("0") && str.length() > 1) || (Long.parseLong(str) > 255)){
                return;
            }
            helper(unprocessed.substring(i, unprocessed.length()), processed + str + "." , count - 1, result);
            i++;
        }
    }

    static boolean isValidIp(String str){
        String[] numbers = str.split("\\.");
        if(numbers.length < 4)
            return false;
        for(String s : numbers){
            if((s.startsWith("0") && s.length() > 1) || (Long.parseLong(s) > 255))
                return false;
        }
        return true;
    }
}
