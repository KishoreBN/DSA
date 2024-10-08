package org.example.Bitwise;

public class NumberOfBitsSet {
    public static void main(String[] args) {
        System.out.println(numberOfBitsSet(1));
    }

    static int numberOfBitsSet(int num){
        int count = 0;
        while(num > 0){
            if((num & 1) == 1)
                count++;
            num = num >> 1;
        }
        return count;
    }
}
