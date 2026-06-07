package com.example.demo.chatgpt.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[][]{};
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> list = new ArrayList<>();

        int[] newInterval = intervals[0];
        list.add(newInterval);

        for (int[] interval : intervals) {
            // if current.start < merged.end then overlap exists
            //So update the end of newInterval accordingly
            if (interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            // If no overlapping start a new newInterval and add it to the list
            } else {
                newInterval = interval;
                list.add(newInterval);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
