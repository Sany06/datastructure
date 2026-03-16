package com.example.demo.chatgpt.heap;

import java.util.PriorityQueue;

public class SumOfElementsBetweenK1AndK2SmallestElements {

    static void main(String[] args) {
        long[]   arr={20, 8, 22, 4, 12, 10, 14};
        System.out.println(sumBetweenTwoKth(arr,7,3,6));
    }
    public static long sumBetweenTwoKth(long A[], long N, long K1, long K2) {
        long k1=findKSmallestElement(A,K1);
        long k2=findKSmallestElement(A,K2);
        long sum=0;

        for(long n:A){
            if(n>k1 && n<k2){
                sum+=n;
            }
        }

        return sum;
    }

    public static long findKSmallestElement(long[] arr,long k){
        PriorityQueue<Long> pq=new PriorityQueue<>((a,b)-> Long.compare(b,a));

        for(long n:arr){
            pq.offer(n);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();

    }
}
