package com.example.demo.chatgpt.intervals;

import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
    public int activitySelection(int[] start, int[] finish) {
        int[][] arr = new int[start.length][2];

        for(int i = 0; i < start.length; i++) {
            arr[i][0] = start[i];
            arr[i][1] = finish[i];
        }

        Arrays.sort(arr, Comparator.comparing(s-> s[1]));

        int tasks = 1;

        int prev = arr[0][1];

        for(int i = 1 ; i < arr.length ; i++) {
            if(arr[i][0] > prev) {
                tasks++;
                prev = arr[i][1];
            }
        }
        return tasks;
    }
}
