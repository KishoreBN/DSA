package org.example.GreedyAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode57 {
    public static void main(String[] args) {
        int[][] intervals = {{1,5}};
        int[] newInterval = {6,8};
        System.out.println(Arrays.toString(insert(intervals, newInterval)));
    }

    public static int[][] insert(int[][]  intervals, int[] newInterval) {
        if(intervals.length == 0){
            return new int[][]{{newInterval[0], newInterval[1]}};
        }
        List<List<Integer>> result = new ArrayList();
        int i = 0;
        while (i < intervals.length && i < intervals.length){
            while (i < intervals.length && intervals[i][1] < newInterval[0]){
                result.add(List.of(intervals[i][0], intervals[i][1]));
                i++;
            }
            while (i < intervals.length && intervals[i][0] <= newInterval[1]){
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
                i++;
            }
            result.add(List.of(newInterval[0], newInterval[1]));
            while (i < intervals.length && i < intervals.length){
                result.add(List.of(intervals[i][0], intervals[i][1]));
                i++;
            }
        }
        int[][] resulArr = new int[result.size()][2];
        for(int j=0; j<result.size(); j++){
            resulArr[j][0] = result.get(j).get(0);
            resulArr[j][1] = result.get(j).get(1);
        }
        return resulArr;
    }
}