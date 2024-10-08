package org.example.Recursion.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode526 {
    public static void main(String[] args) {
        countArrangement(11);
        System.out.println(counter);
    }

    static int counter = 0;
    static void countArrangement(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=1; i<=n; i++){
            arr.add(i);
        }
        permutations(new ArrayList<>(), arr, 0);
    }

    static void permutations(List<Integer> processed, List<Integer> unprocessed, int count){
        if(unprocessed.size() == 0){
            for(int i=0; i<processed.size(); i++){
                if(!((i+1)%processed.get(i) == 0) && !((processed.get(i) % (i+1)) == 0))
                    return;
            }
            counter++;
            return;
        }
        int num = unprocessed.get(0);
        for(int i=0; i<processed.size() + 1; i++){
                List<Integer> internal = new ArrayList<>(processed);
                internal.add(i, num);
                permutations(internal, unprocessed.subList(1, unprocessed.size()), count);
        }
    }
}
