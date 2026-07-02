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

        int[] prevInterval = intervals[0];
        list.add(prevInterval);

        for (int i = 1 ; i< intervals.length; i++) {
            int[] currInterval = intervals[i];
            // if current.start < merged.end then overlap exists
            //So update the end of newInterval accordingly
            if (currInterval[0] <= prevInterval[1]) {
                prevInterval[1] = Math.max(currInterval[1], prevInterval[1]);
            // If no overlapping start a new newInterval and add it to the list
            } else {
                prevInterval = currInterval;
                list.add(prevInterval);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
