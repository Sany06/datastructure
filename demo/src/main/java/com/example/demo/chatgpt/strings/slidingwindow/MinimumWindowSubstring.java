package com.example.demo.chatgpt.strings.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int i = 0, minlen = Integer.MAX_VALUE, start = 0;
        Map<Character,Integer> map = new HashMap<>();

        for(char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }

        int count = map.size();

        for(int j = 0; j < s.length(); j++) {
            char a = s.charAt(j);
            if(map.containsKey(a)) {
                map.put(a, map.get(a) - 1);
                if(map.get(a) == 0) {
                    count--;
                }
            }
            while(count == 0) {
                if(minlen > j - i + 1) {
                    minlen = j - i + 1;
                    start = i;
                }

                char b = s.charAt(i);
                if(map.containsKey(b)) {
                    map.put(b, map.get(b) + 1);
                    if(map.get(b) > 0) count++;
                }
                i++;
            }
        }
        return minlen == Integer.MAX_VALUE ? "" : s.substring(start, start + minlen);
    }
}
