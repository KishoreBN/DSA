package org.example.Recursion.LeetCode;

public class LeetCode306 {
    public static void main(String[] args) {
        System.out.println(isAdditiveNumber("11235813213455890144"));
//        System.out.println(Long.parseLong("11235813213455890144"));
    }

    static boolean isAdditiveNumber(String num) {
        return helper(num,"", 0, 0, 0, 0);
    }

    static boolean helper(String unprocessed, String processed, int index, long result, long previousNum, long numberCount){
        if(index == unprocessed.length() && numberCount >= 3){
            System.out.println(processed);
            return true;
        }
        long currNum = 0;
        for(int i=index; i<unprocessed.length(); i++){
            currNum = currNum * 10 + (unprocessed.charAt(i) - '0');
            if(unprocessed.substring(index, i + 1).length() > 1 && unprocessed.substring(index, i + 1).startsWith("0"))
                return false;
            if(numberCount < 2 || index == 0 || currNum == result){
                if(helper(unprocessed, index != 0 ? processed + "+" + currNum : currNum + "", i + 1,  previousNum + currNum, currNum, numberCount + 1)){
                    return true;
                }
            }
        }
        return false;
    }

    static boolean helper2(String s, int n, int index, int p1, int p2, int count){
        if(index == n){
            return count >=3;
        }
        int num = 0;
        for(int i=index; i<n; i++){
            num = num * 10 + (s.charAt(i) - '0');
            System.out.println(num);
            if(p1 == -1 || p2 == -1 || p1 + p2 == num){
                if(helper2(s, n, i+1, p2, num, count + 1)){
                    return true;
                }
            }
            if(s.charAt(index) == '0'){
                break;
            }
        }
        return false;
    }
}
