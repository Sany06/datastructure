package com.example.demo.chatgpt.intervals;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons {

    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points, Comparator.comparingInt(a-> a[1]));

        int arrows = 1;
        int arrowpos = points[0][1];

        for (int i = 1; i < points.length ; i++) {
            //Does this balloon start after my current arrow position?
            if (points[i][0] > arrowpos){
                arrows++;
                arrowpos = points[i][1];
            }
        }

        return arrows;

    }
}
