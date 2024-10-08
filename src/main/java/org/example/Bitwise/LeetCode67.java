package org.example.Bitwise;

public class LeetCode67 {
    public static void main(String[] args) {
        System.out.println(addBinary("11", "11"));
    }

    static String addBinary(String a, String b) {
        if ( a.length() > b.length()){
            b = padding(b, a.length() - b.length());
        } else {
            a = padding(a, b.length() - a.length());
        }
        int i = a.length() - 1, sum = 0, carry = 0;
        StringBuilder result = new StringBuilder("");
        while(i >= 0){
           int temp = carry + (a.charAt(i) - '0') + (b.charAt(i) - '0');
            sum = temp % 2;
            carry = temp / 2;
            result.append(sum);
            i--;
        }
        if(carry > 0)
            result.append(carry);
        return result.reverse().toString();
    }

    static String padding(String str, int paddingCount){
        StringBuilder result = new StringBuilder();
        while (paddingCount > 0){
            result.append("0");
            paddingCount--;
        }
        return result.append(str).toString();
    }

}
