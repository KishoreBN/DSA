package org.example.Sorting.BubbleSort.BubbleSort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*
        Time Complexity : O(n2)
        Space Complexity: O(1)
    */
    static void bubbleSort(int[] arr){
        boolean isSwapped;
        for(int i=0; i<arr.length; i++){
            isSwapped = false;
            for(int j=1; j<arr.length - i; j++){
                if(arr[j - 1] > arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    isSwapped = true;
                }
            }
            if(!isSwapped){
                break;
            }
        }
    }
}
