package com.example.demo.chatgpt.strings.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int i = 0;
        Map<Character,Integer> map = new HashMap<>();

        for(char ch: s1.toCharArray()) {
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }

        int count = map.size();

        for(int j = 0; j< s2.length(); j++) {
            char a = s2.charAt(j);

            if(map.containsKey(a)) {
                map.put(a, map.get(a) - 1);
                if( map.get(a) == 0) {
                    count--;
                }
            }

            if(j - i + 1 > s1.length()) {
                char b = s2.charAt(i);
                if(map.containsKey(b)) {
                    map.put(b, map.get(b) + 1);
                    if(map.get(b) == 1) count++;
                }
                i++;
            }
            if(count == 0 && j - i + 1 == s1.length()) return true;

        }
        return false;
    }
}
