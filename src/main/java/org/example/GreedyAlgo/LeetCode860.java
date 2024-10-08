package org.example.GreedyAlgo;

public class LeetCode860 {
    public static void main(String[] args) {
        int[] bills = {5,5,10,10,20};
        System.out.println(lemonadeChange(bills));
    }

    public static boolean lemonadeChange(int[] bills) {
        int doll_5 = 0, doll_10 = 0;
        for(int i=0; i<bills.length; i++){
            if(bills[i] == 5){
                doll_5++;
            } else if(bills[i] == 10){
                if(doll_5 == 0)
                    return false;
                doll_5--;
                doll_10++;
            } else {
                if(doll_10 > 0 && doll_5 > 0){
                    doll_10--;
                    doll_5--;
                } else if(doll_5 >= 3){
                    doll_5 = doll_5 - 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
