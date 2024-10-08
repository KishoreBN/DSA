package org.example.SlidingWindow_TwoPointer;

public class LeetCode904 {
    public static void main(String[] args) {
        int[] fruits = {0,1,2,2};
        System.out.println(totalFruit(fruits));
    }

    public static int totalFruit(int[] fruits) {
        int left = 0, right = 0, leftType = -1, rightType = -1, leftBasket = 0, rightBasket = 0;
        int maxBasket = 0;
        while (right < fruits.length){
            if(leftType == -1 || rightType == -1){
                if(leftType == - 1)
                    leftType = fruits[right];
                else
                    rightType = fruits[right];
            }
            if(fruits[right] == leftType)
                leftBasket++;
            else if(fruits[right] == rightType)
                rightBasket++;
            else {
                while (leftBasket != 0 && rightBasket != 0){
                    if(fruits[left] == leftType)
                        leftBasket--;
                    else
                        rightBasket--;
                    left++;
                }
                if(leftBasket == 0){
                    leftType = fruits[right];
                    leftBasket = 1;
                } else {
                    rightType = fruits[right];
                    rightBasket = 1;
                }
            }
            maxBasket = Math.max(maxBasket, leftBasket + rightBasket);
            right++;
        }
        maxBasket = Math.max(maxBasket, leftBasket + rightBasket);
        return maxBasket;
    }
}
