package com.example.demo.chatgpt.arrays;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for (String s : strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

//        return map.entrySet().stream()
//                .map(s-> map.put(s.getKey(),s.getValue()))
//                .toList();
        return new ArrayList<>(map.values());
    }
}
