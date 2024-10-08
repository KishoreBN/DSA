package org.example.Recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSequence {
    public static void main(String[] args) {
        String str = "abc";
        ArrayList<String> result = new ArrayList<>();
        subSequence(str, "", result);
        System.out.println(result);
    }

    static void subSequence(String unprocessed, String processed, List<String> result){
        if(unprocessed.isEmpty()){
            if(!processed.isEmpty()) {
                result.add(processed);
            }
            return;
        }
        char ch = unprocessed.charAt(0);
        subSequence(unprocessed.substring(1), processed + ch, result);
        subSequence(unprocessed.substring(1), processed, result);
    }
}
