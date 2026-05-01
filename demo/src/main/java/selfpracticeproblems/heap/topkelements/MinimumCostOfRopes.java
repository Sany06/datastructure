package selfpracticeproblems.heap.topkelements;

import java.util.PriorityQueue;

public class MinimumCostOfRopes {
    static void main(String[] args) {
        int[] arr = {4, 3, 2, 6};
        System.out.println(minCost(arr));
    }

    public static int minCost(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0;
        for (int num : arr) {
            pq.offer(num);
        }

        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            int total = a + b;
            pq.offer(total);
            count += total;

        }
        return count;
    }
}
