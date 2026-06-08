package com.example.demo.chatgpt.intervals;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoomsII {
    public int minMeetingRooms(int[] start, int[] end) {
        Arrays.sort(start);
        Arrays.sort(end);
        int rooms = 0, maxrooms = 0;

        int s = 0, e = 0;

        while(s < start.length) {
            //Does the next meeting start before the earliest currently-known meeting ends?
            // if yes -> rooms++ else rooms--
            if(start[s] < end[e] ) {
                rooms++;
                s++;
                maxrooms = Math.max(rooms,maxrooms);
            } else {
                rooms--;
                e++;
            }
        }
        return maxrooms;
    }
}
