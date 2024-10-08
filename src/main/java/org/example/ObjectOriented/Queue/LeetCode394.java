package org.example.ObjectOriented.Queue;

import java.util.Stack;

public class LeetCode394 {
    public static void main(String[] args) {
        System.out.println(helper("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }

    public static String decodeString(String s) {
        Stack<Integer> number = new Stack<>();
        number.push(0);
        Stack<Character> bracket = new Stack<>();
        Stack<String> alphabets = new Stack<>();
        StringBuilder result = new StringBuilder();
        int i =0 ;
        while(i < s.length()){
            char c = s.charAt(i);
            if(c >= 'a' && c <= 'z'){
                if(alphabets.empty()){
                    alphabets.push(c+"");
                } else {
                    alphabets.push(alphabets.pop() + c);
                }
            }else if(c == ']' || c == '['){
                if(c == ']' && !bracket.empty() && bracket.peek() == '['){
                    bracket.pop();
                    int num = number.pop();
                    String str = alphabets.pop();
                    StringBuilder temp = new StringBuilder();
                    for(int j=0; j<num; j++){
                        temp.append(str);
                    }
                    if(bracket.empty()){
                        result.append(temp);
                    }
                    if(!alphabets.empty()) {
                        alphabets.push(alphabets.pop() + temp);
                    }
                } else {
                    bracket.push(c);
                    alphabets.push("");
                }
            } else {
                int num = 0;
                do{
                    num = (num * 10) + Integer.parseInt(s.charAt(i) + "");
                    i++;
                }while(s.charAt(i) - '0' >= '0' && s.charAt(i) - '0' <= 9);
            }
            i++;
        }
        if(!alphabets.empty()){
            result.append(alphabets.pop());
        }
        return result.toString();
    }

    public static String helper(String s){
        Stack<String> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c == ']' && !stack.empty()){
                StringBuilder str = new StringBuilder();
                while(!stack.empty() && !stack.peek().startsWith("[")){
                    str.insert(0, stack.pop());
                }
                StringBuilder num = new StringBuilder();
                stack.pop();
                while (!stack.empty() && isNumeric(stack.peek())){
                    num.insert(0, stack.pop());
                }
                StringBuilder subStr = new StringBuilder();
                for(int i=0; i<Integer.parseInt(num.toString()); i++){
                    subStr.append(str);
                }
                if(stack.empty() || stack.peek().equals("["))
                    stack.push(subStr.toString());
                else
                    stack.push(stack.pop() + subStr);
            } else {
                stack.push(c+"");
            }
        }
        while (!stack.empty()){
            result.insert(0, stack.pop());
        }
        return result.toString();
    }

    public static boolean isNumeric(String str){
        if(str == null)
            return false;
        try{
            Integer.parseInt(str);
            return true;
        } catch (Exception e){
            return false;
        }
    }

}
