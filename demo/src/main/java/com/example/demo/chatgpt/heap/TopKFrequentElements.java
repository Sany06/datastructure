package com.example.demo.chatgpt.heap;

import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        record MyClass(int freq, int num) {

        }
        PriorityQueue<MyClass> pq = new PriorityQueue<>((a, b) -> a.freq - b.freq);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (var entry : map.entrySet()) {
            MyClass myClass = new MyClass(entry.getValue(), entry.getKey());
            pq.offer(myClass);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] arr = new int[pq.size()];
        int index = 0;
        while (!pq.isEmpty()) {
            arr[index] = pq.poll().num();
            index++;
        }
        return arr;

//        return map.entrySet().stream().map(entry -> {
//            MyClass myClass = new MyClass(entry.getValue(), entry.getKey());
//            pq.offer(myClass);
//            if (pq.size() > k) {
//                pq.poll();
//            }
//            return pq;
//        }).reduce((a, b) -> b) // get last element
//                .map(myClasses -> {
//            int[] arr = new int[pq.size()];
//            int index = 0;
//            while (!pq.isEmpty()) {
//                arr[index] = pq.poll().getNum();
//                index++;
//            }
//            return arr;
//        }).orElse(new int[0]);


    }
}
