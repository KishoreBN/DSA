package org.example;

public class Armstrong {
    public static void main(String[] args) {
        System.out.println(isArmStrongNumber(154));
    }

    static boolean isArmStrongNumber(int num){
        int originalNum = num;
        double result = 0;
        while(num > 0){
            result = result + Math.pow(num % 10, 3);
            num = num /10;
        }
        return originalNum == result;
    }
}
