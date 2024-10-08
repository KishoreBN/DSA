package org.example.Bitwise;

public class MagicNumber {
    public static void main(String[] args) {
        System.out.println(magicNumber(5));
    }

    static int magicNumber(int num){
        int count = 1, result = 0;
        for(int i=0; i<32; i++){
            if(((num >> i) & 1) == 1){
                result = (int) (result + (Math.pow(5,count)));
            }
            count++;
        }
        return result;
    }
}
