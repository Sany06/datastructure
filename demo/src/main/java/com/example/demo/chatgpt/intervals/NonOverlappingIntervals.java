package com.example.demo.chatgpt.intervals;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {

        if (intervals.length == 0)
            return 0;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int nonOverLappingCount = 1;

        int previousIntervalIndex = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= intervals[previousIntervalIndex][1]) {
                previousIntervalIndex = i;
                nonOverLappingCount++;
            }
        }

        return intervals.length - nonOverLappingCount;
    }
}
