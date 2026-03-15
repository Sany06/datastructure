package com.example.demo.chatgpt.binarysearch.binarysearchonanswers;

import java.util.Arrays;

public class AggressiveCows {
    public int aggressiveCows(int[] stalls, int k) {
        int ans = 0;
        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPlace(stalls, mid, k)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean canPlace(int[] stalls, int mid, int k) {
        int noOfCows = 1;
        int lastPosition = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPosition >= mid) {
                lastPosition = stalls[i];
                noOfCows++;
            }
        }
        return noOfCows >= k;

    }
}
