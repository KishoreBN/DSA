package org.example.GreedyAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LeetCode56 {
    public static void main(String[] args) {
        int[][] intervals = {{1,4},{2,4}};
        merge(intervals);
    }

    public static int[][] merge(int[][] intervals) {
        Interval[] interval = new Interval[intervals.length];
        for(int i=0; i<intervals.length; i++){
            interval[i] = new Interval(intervals[i][0], intervals[i][1]);
        }
        Arrays.sort(interval, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        List<List<Interval>> mergedList = new ArrayList<>();
        int i=0;
        while (i < interval.length - 1){
            while (i < interval.length - 1 && interval[i].end < interval[i + 1].start){
                mergedList.add(new ArrayList<>(List.of(interval[i])));
                i++;
            }
            Interval newInterval = new Interval(interval[i].start, interval[i].end);
            while (i < interval.length - 1 && newInterval.end >= interval[i + 1].start){
                newInterval.start = Math.min(newInterval.start, interval[i + 1].start);
                newInterval.end = Math.max(newInterval.end, interval[i + 1].end);
                i++;
            }
            mergedList.add(new ArrayList<>(List.of(newInterval)));
            i++;
        }
        if(mergedList.size() == 0 || interval[interval.length - 1].end > mergedList.get(mergedList.size() - 1).get(0).end){
            mergedList.add(new ArrayList<>(List.of(interval[interval.length - 1])));
        }
        int[][] mergedArr = new int[mergedList.size()][2];
        for(int j=0; j<mergedList.size(); j++){
            mergedArr[j][0] = mergedList.get(j).get(0).start;
            mergedArr[j][1] = mergedList.get(j).get(0).end;
        }
        System.out.println(mergedList);
        return mergedArr;
    }
}
