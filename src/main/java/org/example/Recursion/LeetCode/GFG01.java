package org.example.Recursion.LeetCode;


import java.util.ArrayList;
import java.util.List;

/*
Given three numbers sum S, prime P, and N, find all N prime numbers after prime P such that their sum is equal to S.
Input :  N = 2, P = 7, S = 28
Output : 11 17
Explanation : 11 and 17 are primes after
prime 7 and (11 + 17 = 28)

Input :  N = 3, P = 2, S = 23
Output : 3 7 13
         5 7 11
Explanation : 3, 5, 7, 11 and 13 are primes
after prime 2. And (3 + 7 + 13 = 5 + 7 + 11
= 23)
*/
public class GFG01 {
    public static void main(String[] args) {
        primeSum(4,3, 54);
    }

    static void primeSum(int n, int p, int s){
        helper(new ArrayList<>(), n, p+1, s);
    }

    static void helper(List<Integer> subset, int n, int p, int s){
        if(subset.size() == n && s == 0){
            System.out.println(subset);
            return;
        }
        if(s < 0 || subset.size() > n){
            return;
        }
        int i = p;
        while(i <= s) {
            while (!isPrime(i)) {
                i++;
            }
            subset.add(i);
            helper(subset, n, i + 1, s - i);
            subset.remove(subset.size() - 1);
            i++;
        }
    }

    static boolean isPrime(int n){
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n%i == 0)
                return false;
        }
        return true;
    }
}
