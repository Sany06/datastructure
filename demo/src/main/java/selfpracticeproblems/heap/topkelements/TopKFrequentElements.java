package selfpracticeproblems.heap.topkelements;

import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    class MyClass {
        public int val, freq;
        public MyClass(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {

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
            arr[index] = pq.poll().val;
            index++;
        }
        return arr;
    }
}
