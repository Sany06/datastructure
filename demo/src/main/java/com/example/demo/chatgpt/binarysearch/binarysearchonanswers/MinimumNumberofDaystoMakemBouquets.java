package com.example.demo.chatgpt.binarysearch.binarysearchonanswers;

public class MinimumNumberofDaystoMakemBouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) return -1;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int ans = -1;

        for (int bloomday : bloomDay) {
            min = Math.min(min, bloomday);
            max = Math.max(max, bloomday);
        }

        while (min <= max) {
            int mid = min + (max - min) / 2;

            if (isBouquetPossible(bloomDay, mid, m, k)) {
                ans = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return ans;
    }

    private boolean isBouquetPossible(int[] bloomDay, int mid, int m, int k) {
        int flower = 0;
        int bouquetCount = 0;
        for (int bloomday : bloomDay) {
            if (bloomday <= mid) {
                flower++;
                if (flower == k) {
                    bouquetCount++;
                    flower = 0;
                }
            } else {
                flower = 0;
            }
        }
        return bouquetCount >= m;
    }
}
