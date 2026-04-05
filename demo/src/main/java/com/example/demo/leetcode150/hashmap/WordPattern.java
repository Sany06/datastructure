package com.example.demo.leetcode150.hashmap;

import java.util.HashMap;
import java.util.Objects;

public class WordPattern {
    static void main(String[] args) {
        System.out.println(wordPattern("abba","dog cat dog cat"));
    }
    public static boolean wordPattern(String pattern, String s) {
        if (pattern.length() != s.split(" ").length){
            return false;
        }

        HashMap<Object, Integer> map = new HashMap<>();
        String[] arr = s.split(" ");

        for (int i = 0; i < pattern.length(); i++){
            if (!Objects.equals(map.put(pattern.charAt(i), i),map.put(arr[i], i))) {
                return false;
            }
        }
        return true;
    }
}
