package org.example.Search.BinarySearch;

public class LeetCode744 {
    public static void main(String[] args) {
        char[] arr = {'x', 'x', 'y', 'y'};
        char target = 'y';
        System.out.println(nextGreatestLetter(arr, target));
    }

    static char nextGreatestLetter(char[] letters, char target){
        if(target >= letters[letters.length - 1])
            return letters[0];
        int startIndex = 0, endIndex = letters.length - 1, mid;
        while (startIndex <= endIndex){
            mid = startIndex + (endIndex - startIndex) / 2;
            if(letters[mid] > target)
                endIndex = mid - 1;
            else
                startIndex = mid + 1;
        }
        return letters[startIndex ];
    }
}
