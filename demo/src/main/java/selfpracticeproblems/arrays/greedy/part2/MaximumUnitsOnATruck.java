package selfpracticeproblems.arrays.greedy.part2;

import java.util.Arrays;

public class MaximumUnitsOnATruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int totalunits = 0;

        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        for(int[] box : boxTypes) {
            int boxes = Math.min(box[0],truckSize);

            totalunits += boxes * box[1];
            truckSize -= boxes;

            if(truckSize == 0) break;
        }
        return totalunits;
    }
}
