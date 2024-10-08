package org.example.GreedyAlgo;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Job Sequencing Problem
 * Difficulty: Medium Accuracy: 34.51% Submissions: 252K+ Points: 4
 * Given a set of n jobs where each jobi has a deadline and profit associated with it.
 *
 * Each job takes 1 unit of time to complete and only one job can be scheduled at a time. We earn the profit associated with a job if and only if the job is completed by its deadline.
 *
 * Find the number of jobs done and the maximum profit.
 *
 * Note: Jobs will be given in the form (Jobid, Deadline, Profit) associated with that Job. Deadline of the job is the time on or before which job needs to be completed to earn the profit.
 *
 * Examples :
 *
 * Input: Jobs = [[1,4,20],[2,1,1],[3,1,40],[4,1,30]]
 * Output: 2 60
 * Explanation: Job1 and Job3 can be done with maximum profit of 60 (20+40).
 * Input: Jobs = [[1,2,100],[2,1,19],[3,2,27],[4,1,25],[5,1,15]]
 * Output: 2 127
 * Explanation: 2 jobs can be done with maximum profit of 127 (100+27).
 * Expected Time Complexity: O(nlogn)
 * Expected Auxilliary Space: O(n)
 *
 * Constraints:
 * 1 <= n <= 105
 * 1 <= Deadline,id <= n
 * 1 <= Profit <= 500
 */
public class GFG01 {
    public static void main(String[] args) {
        Job arr[] = { new Job(1,4, 20), new Job(2,1,1), new Job(3,1,40), new Job(4,1,30) };
        System.out.println(Arrays.toString(JobScheduling(arr)));
    }

    public static int[] JobScheduling(Job arr[])
    {
        Arrays.sort(arr, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o2.profit - o1.profit;
            }
        });
        int maxDeadline = 0;
        for(int i=0; i<arr.length; i++){
            maxDeadline = Math.max(maxDeadline, arr[i].deadline);
        }
        int[] days = new int[maxDeadline];
        int maxProfit = 0, jobsDone = 0;
        for(int i=0; i<arr.length; i++){
            if(days[arr[i].deadline - 1] == 0){
                days[arr[i].deadline - 1] = arr[i].id;
                maxProfit += arr[i].profit;
                jobsDone++;
            } else {
                int j = arr[i].deadline - 1;
                while (j >= 0 && days[j] != 0){
                    j--;
                }
                if(j >= 0){
                    days[j] = arr[i].id;
                    maxProfit += arr[i].profit;
                    jobsDone++;
                }
            }
        }
        return new int[]{jobsDone, maxProfit};
    }
}

class Job {
    public int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}
