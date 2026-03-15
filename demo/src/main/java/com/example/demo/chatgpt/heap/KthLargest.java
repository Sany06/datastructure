package com.example.demo.chatgpt.heap;

import java.util.PriorityQueue;
//kth largest element in a stream
public class KthLargest {

    PriorityQueue<Integer> pq;
    int capacity=0;

    public KthLargest(int k, int[] nums) {
        pq=new PriorityQueue<>();
        this.capacity=k;

        for(int num:nums){
            pq.offer(num);

            if(pq.size()>k){
                pq.poll();
            }
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size()>capacity) {
            pq.poll();
        }
        return pq.peek();
    }

}
