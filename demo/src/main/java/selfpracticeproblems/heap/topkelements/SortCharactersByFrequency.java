package selfpracticeproblems.heap.topkelements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
    class MyClass {
        int freq;
        char c;

        public MyClass(int freq, char c) {
            this.freq = freq;
            this.c = c;
        }
    }
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<MyClass> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (var entry : map.entrySet()) {
            MyClass me = new MyClass(entry.getValue(), entry.getKey());
            pq.offer(me);
        }

        StringBuffer sb = new StringBuffer();

        while (!pq.isEmpty()) {
            MyClass me = pq.poll();

            for ( int i = 0 ; i < me.freq ; i++ ) {
                sb.append(me.c);
            }
        }
        return sb.toString();
    }
}
