package com.example.demo.chatgpt.bitmanipulation;

import java.util.HashMap;
import java.util.Map;

public class MaximumLengthOfContiguousSubarrayWhoseBitwiseXORZero {
    public static int maxLength(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        int maxLength = 0;
        int xor = 0;

        map.put(0,-1);

        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];

            if (map.containsKey(xor)) {
                maxLength = Math.max(maxLength, i - map.get(xor));
            } else {
                map.put(xor,i);
            }
        }
        return maxLength;
    }
}
