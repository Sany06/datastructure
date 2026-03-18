package com.example.demo.chatgpt.intervals;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int[][] newarr= new int[n+1][2];

        for (int i=0;i< intervals.length;i++){
            newarr[i]=intervals[i];
        }
        newarr[n]=newInterval;
        return MergeIntervals.merge(newarr);
    }
}
