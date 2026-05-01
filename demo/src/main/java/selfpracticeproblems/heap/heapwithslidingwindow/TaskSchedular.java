package selfpracticeproblems.heap.heapwithslidingwindow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class TaskSchedular {
    public int leastInterval(char[] tasks, int n) {
        // Frequency map to store the count of each task
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Max-Heap to store frequencies
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) {
            if (f > 0) pq.add(f);
        }

        int time = 0;
        while (!pq.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int cycle = n + 1;

            while (cycle > 0 && !pq.isEmpty()) {
                int current = pq.poll();
                if (current - 1 > 0) {
                    temp.add(current - 1);
                }
                time++;
                cycle--;
            }

            for (int t : temp) {
                pq.offer(t);
            }

            if (!pq.isEmpty()) {
                time += cycle;
            }
        }

        return time;
    }
}
