package com.example.demo.chatgpt.dynamicprogramming;

public class HouseRobberII {

    public int robII(int[] nums) {
        if (nums.length < 2) return nums[0];

        int[] skipFirstHouse = new int[nums.length - 1];
        int[] skipLastHouse = new int[nums.length - 1];

        for (int i = 0; i < nums.length - 1; i++) {
            skipFirstHouse[i] = nums[i + 1];
            skipLastHouse[i] = nums[i];
        }

        int resultOfSkipFirstHouse=rob(skipFirstHouse);
        int resultOfSkipLastHouse=rob(skipLastHouse);

        return Math.max(resultOfSkipFirstHouse,resultOfSkipLastHouse);

    }

    public int rob(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }
        int[] result = new int[nums.length];

        result[0] = nums[0];
        result[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            result[i] = Math.max(result[i - 2] + nums[i], result[i - 1]);
        }

        return result[result.length - 1];

    }
}
