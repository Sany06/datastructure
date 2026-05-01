package selfpracticeproblems.heap.huffmanpattern;

import java.util.HashMap;
import java.util.PriorityQueue;

public class ReorganizeString {
    // In a string of length n the max possible count of a char is defined by the
    // following formula (n+1)/2
    class MyClass {
        char character;
        int count;

        public MyClass(char character, int count) {
            this.character = character;
            this.count = count;
        }
        public char getCharacter(){
            return character;
        }
        public int getCount(){
            return count;
        }
    }
    public String reorganizeString(String s) {
        if (s.length()==1) return s;
        int maxCountOfAChar = (s.length() + 1) / 2;
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int val : map.values()) {
            if (val > maxCountOfAChar) {
                return "";
            }
        }

        PriorityQueue<MyClass> pq = new PriorityQueue<>((a, b) -> b.count - a.count);

        for (var entry : map.entrySet()) {
            MyClass myClass = new MyClass(entry.getKey(), entry.getValue());
            pq.offer(myClass);
        }

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty() && pq.size()>1){
            MyClass char1 = pq.poll();
            MyClass char2=pq.poll();

            if (char1.getCount()>0) {
                sb.append(char1.character);
                pq.offer(new MyClass(char1.character,char1.getCount() -  1));
            }
            if (char2.getCount()>0) {
                sb.append(char2.character);
                pq.offer(new MyClass(char2.character, char2.getCount() - 1));
            }
        }
        return sb.toString();

    }


}
