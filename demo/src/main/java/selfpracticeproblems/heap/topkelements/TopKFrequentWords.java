package selfpracticeproblems.heap.topkelements;

import java.util.*;

public class TopKFrequentWords {
    class MyClass {
        int freq;
        String word;

        public MyClass(int freq, String word) {
            this.freq = freq;
            this.word = word;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {

        Map<String , Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<MyClass> pq = new PriorityQueue<>((a, b) -> {
            if (a.freq == b.freq) {
                return b.word.compareTo(a.word);
            }

            return a.freq - b.freq;

        });

        for (var entry : map.entrySet()) {
            MyClass m = new MyClass(entry.getValue(), entry.getKey());
            pq.offer(m);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<String> list = new ArrayList<>();

        while(!pq.isEmpty()) {
            MyClass m = pq.poll();
            list.add(m.word);
        }

        Collections.reverse(list);
        return list;
    }
}
