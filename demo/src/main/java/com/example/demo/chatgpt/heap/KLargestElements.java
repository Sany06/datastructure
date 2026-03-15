package com.example.demo.chatgpt.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KLargestElements {
    public List<Integer> kLargest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num:arr){
            pq.offer(num);{
                if (pq.size()> k){
                    pq.poll();
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!pq.isEmpty()){
            list.add(pq.poll());
        }
        Collections.reverse(list);
        return list;
    }
}
