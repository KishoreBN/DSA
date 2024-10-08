package org.example.Recursion;

import java.util.ArrayList;
import java.util.List;

public class DiceThrow {
    public static void main(String[] args) {
        diceThrowV2(3, new ArrayList<>());
    }

    static void diceThrow(int target){
        List<ArrayList<Integer>> subset = new ArrayList<>();
        List<ArrayList<Integer>> result = new ArrayList<>();
        subset.add(new ArrayList<>());
        for(int i=1; i<=6; i++){
            int n = subset.size();
            for(int j=0; j<n; j++){
                ArrayList<Integer> internal = new ArrayList<>(subset.get(j));
                internal.add(i);
                int runningSum = 0;
                for(int k : internal){
                    runningSum += k;
                }
                if(runningSum == target){
                    result.add(internal);
                }
                subset.add(internal);
            }
        }
        System.out.println(result);
    }

    static void diceThrowV2(int target, ArrayList<Integer> processed){
        if(target == 0){
            System.out.println(processed);
            return;
        }
        for(int i=1; i<=6 && i<=target; i++){
            ArrayList<Integer> internal = new ArrayList<>(processed);
            internal.add(i);
            diceThrowV2(target - i, internal);
        }
    }
}
