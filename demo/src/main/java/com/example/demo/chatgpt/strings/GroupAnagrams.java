package com.example.demo.chatgpt.strings;

import java.util.*;

public class GroupAnagrams {
    static void main() {
        String[] string={"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(string));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str:strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            //If the key is not present in the map then it creates a new entry with  empty Arraylist in the map and adds the value
            // against the key
            // If the key is present then it simply adds the val against the corresponding key
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
            }
        return new ArrayList<>(map.values());
    }
}
