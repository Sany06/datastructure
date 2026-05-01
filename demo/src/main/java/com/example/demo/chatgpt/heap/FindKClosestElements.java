package com.example.demo.chatgpt.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq =   new PriorityQueue<>((a,b) -> {
            int diff = Math.abs(b - x) - Math.abs(a - x);
            if (diff == 0) {
                return b - a;
            }
            return diff;
        });

        for (int n : arr) {
            pq.offer(n);
            if (pq.size() > k ){
                pq.poll();
            }
        }

        List<Integer> list = new ArrayList<>(pq);
        Collections.sort(list);
        return list;
    }
}
