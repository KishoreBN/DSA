package org.example.Recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        String str = "abc";
        List<String> result = new ArrayList<>();
        permuatation(str, "", result);
        System.out.println(result);
    }

    static void permuatation(String unprocessed, String processed, List<String> result){
        if(unprocessed.isEmpty()){
            result.add(processed);
            return;
        }
        char ch = unprocessed.charAt(0);
        for(int i=0; i<=processed.length(); i++){
            String internal = processed.substring(0,i) + ch + processed.substring(i, processed.length());
            permuatation(unprocessed.substring(1), internal, result);
        }
    }
}
