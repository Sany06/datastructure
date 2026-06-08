package com.example.demo.chatgpt.intervals;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {

        if (intervals.length == 0)
            return 0;

        Arrays.sort(intervals, Comparator.comparing(s -> s[1]));

        int nonoverlapcount = 1;

        int[] prev = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (curr[0] >= prev[1]) {
                nonoverlapcount++;
                prev = curr;
            }
        }
        // No of overlapping intervals = Total intervals - no of non-overlapping intervals
        return intervals.length - nonoverlapcount;
    }
}
