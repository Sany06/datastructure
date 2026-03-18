package com.example.demo.chatgpt.intervals;

import java.util.Arrays;
import java.util.Comparator;

//GFG Problem
public class MeetingRooms {

    static void main(String[] args) {
        int[][] arr = {{1, 4}, {10, 15} ,{7,10}};
        System.out.println(canAttend(arr));
    }

    static boolean canAttend(int[][] arr) {
        if (arr.length<=1){
            return true;
        }

        Arrays.sort(arr, Comparator.comparingInt(s->s[1]));

        boolean result = true;

        int[] prev = arr[0];

        for (int i=1;i< arr.length;i++) {
            if (arr[i][0] < prev[1]) {
                return false;
            } else {
                prev = arr[i];
            }
        }
        return result;
    }
}
