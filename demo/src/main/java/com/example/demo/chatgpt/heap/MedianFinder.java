package com.example.demo.chatgpt.heap;

import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> left_max_heap;  //max heap stores min half of the nums
    PriorityQueue<Integer> right_min_heap; //min heap stores max half of the nums

    public MedianFinder() {
        left_max_heap = new PriorityQueue<>((a,b)-> b-a);
        right_min_heap = new PriorityQueue<>();
    }

    public void addNum(int num) {

        if( left_max_heap.isEmpty() || num < left_max_heap.peek() ){
            left_max_heap.offer(num);
        } else
            right_min_heap.offer(num);

        // Case 1: right bigger
        if (right_min_heap.size() > left_max_heap.size()) {
            left_max_heap.offer(right_min_heap.poll());
        }

        // Case 2: left too big
        if (left_max_heap.size() - right_min_heap.size() > 1) {
            right_min_heap.offer(left_max_heap.poll());
        }

    }

    public double findMedian() {
        if (left_max_heap.size() > right_min_heap.size()){
            return left_max_heap.peek();
        } else {
            return ( left_max_heap.peek() + right_min_heap.peek()) / 2.0;
        }
    }
}
