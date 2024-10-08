package org.example.GreedyAlgo;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode435 {
    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3},{3,4},{-100,-2},{5,7}};
        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Interval[] interval = new Interval[intervals.length];
        for (int i=0; i<intervals.length; i++){
            interval[i] = new Interval(intervals[i][0], intervals[i][1]);
        }
        Arrays.sort(interval, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });
        int count = 0, lastEnd = Integer.MIN_VALUE;
        for(int i=0; i<interval.length; i++){
            if(interval[i].start >= lastEnd){
                count++;
                lastEnd = interval[i].end;
            }
        }
        return interval.length - count;
    }
}

class Interval{
    int start;
    int end;
    Interval(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
