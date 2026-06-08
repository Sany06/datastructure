package com.example.demo.chatgpt.intervals;

import java.util.Arrays;
import java.util.Comparator;

//GFG Problem
public class MeetingRooms {

    static void main(String[] args) {
        int[][] arr = {{1, 4}, {10, 15}, {7, 10}};
        System.out.println(canAttend(arr));
    }

    static boolean canAttend(int[][] arr) {
        if (arr.length <= 1) {
            return true;
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a[1]));

        int[] previnterval = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int[] currinterval = arr[i];
            if (currinterval[0] < previnterval[1]) {
                return false;
            }
            previnterval = currinterval;
        }
        return true;
    }
}
