package org.example.GreedyAlgo;

import java.util.Arrays;
import java.util.Comparator;

/**
 * You are given timings of n meetings in the form of (start[i], end[i]) where start[i] is the start time of meeting i and end[i] is the finish time of meeting i. Return the maximum number of meetings that can be accommodated in a single meeting room, when only one meeting can be held in the meeting room at a particular time.
 *
 * Note: The start time of one chosen meeting can't be equal to the end time of the other chosen meeting.
 *
 * Examples :
 *
 * Input: n = 6, start[] = [1, 3, 0, 5, 8, 5], end[] =  [2, 4, 6, 7, 9, 9]
 * Output: 4
 * Explanation: Maximum four meetings can be held with given start and end timings. The meetings are - (1, 2), (3, 4), (5,7) and (8,9)
 * Input: n = 3, start[] = [10, 12, 20], end[] = [20, 25, 30]
 * Output: 1
 * Explanation: Only one meetings can be held with given start and end timings.
 * Expected Time Complexity: O(n*logn)
 * Expected Auxilliary Space: O(n)
 *
 * Constraints:
 * 1 ≤ n ≤ 105
 * 0 ≤ start[i] < end[i] ≤ 106
 */
public class GFG02 {
    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        System.out.println(maxMeetings(6,start, end));
    }

    public static int maxMeetings(int n, int start[], int end[]) {
        // add your code here
        Meeting[] meetings = new Meeting[start.length];
        int count = 0, previousEndTime = 0;
        for(int i=0; i<start.length; i++){
            meetings[i] = new Meeting(start[i], end[i]);
        }
        Arrays.sort(meetings, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                return o1.endTime - o2.endTime;
            }
        });
        for(int i=0; i<meetings.length; i++){
            if(previousEndTime < meetings[i].startTime) {
                count++;
                previousEndTime = meetings[i].endTime;
            }
        }
        return count;
    }
}

class Meeting{
    int startTime;
    int endTime;
    Meeting(int startTime, int endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
