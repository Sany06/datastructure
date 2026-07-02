package com.example.demo.chatgpt.intervals;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {

        if (intervals.length == 0)
            return 0;

        int overlap = 0;

        Arrays.sort(intervals, Comparator.comparing(s-> s[0]));

        int[] prev = intervals[0];

        for (int i = 1; i< intervals.length ; i++) {
            int[] curr = intervals[i];

            if(curr[0] < prev[1]){
                overlap++;
                prev[1] = Math.min(curr[1],prev[1]);  // this is the only diff Math.min
            } else {
                prev = curr;
            }
        }
        return overlap;
    }
}
