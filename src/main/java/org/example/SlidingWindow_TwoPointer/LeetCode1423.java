package org.example.SlidingWindow_TwoPointer;

public class LeetCode1423 {
    public static void main(String[] args) {
        int[] cardPoints = {9,7,7,9,7,7,9};
        System.out.println(maxScore(cardPoints, 7));
    }

    public static int maxScore(int[] cardPoints, int k) {
        int maxSum = Integer.MIN_VALUE, sum = 0, leftSum = 0, rightSum = 0;
        for(int i=0; i<k; i++){
            leftSum += cardPoints[i];
        }
        if(k == cardPoints.length)
            return leftSum;
        maxSum = Math.max(maxSum, leftSum);
        for(int i=k-1, j=cardPoints.length - 1; i>=0 && j>=0; i--, j--){
            leftSum = leftSum - cardPoints[i];
            rightSum = rightSum + cardPoints[j];
            maxSum = Math.max(leftSum + rightSum, maxSum);
        }
        return maxSum;
    }
}
