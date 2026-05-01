package com.example.demo.chatgpt.heap;

import java.util.PriorityQueue;
//gfg
public class SortKSortedArray {
    public void nearlySorted(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int index = 0;

        for (int i = 0 ; i < arr.length ; i++) {
            pq.offer(arr[i]);

            if (pq.size() > k) {
                arr[index] = pq.poll();
                index++;
            }
        }

        while (!pq.isEmpty()) {
            arr[index] = pq.poll();
            index++;
        }
    }
}
