package org.example.Bitwise;

public class Power {
    public static void main(String[] args) {
        System.out.println(power(2,2));
    }

    static long power(int base, int pow){
        int ans = 1;
        while(pow > 0){
            if((pow & 1) == 1)
                ans = ans * base;
            base = base * base;
            pow = pow >> 1;
        }
        return ans;
    }
}
