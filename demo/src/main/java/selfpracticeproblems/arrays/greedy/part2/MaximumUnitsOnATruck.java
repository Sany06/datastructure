package selfpracticeproblems.arrays.greedy.part2;

import java.util.Arrays;

public class MaximumUnitsOnATruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int totalunits = 0;

        //Sort boxTypes based on the value at index 1, from largest to smallest.
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        for(int[] box : boxTypes) {
            int numberOfBoxes = Math.min(box[0],truckSize);

            totalunits += numberOfBoxes * box[1];
            truckSize -= numberOfBoxes;

            if(truckSize == 0) break;
        }
        return totalunits;
    }
}
