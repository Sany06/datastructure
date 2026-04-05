package com.example.demo.leetcode150.hashmap;

import java.util.HashMap;
import java.util.Objects;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();

        for(int i = 0 ; i < s.length() ; i++){
            if (!Objects.equals(map1.put(s.charAt(i), i ), map2.put(t.charAt(i),  i ))){
                return false;
            }
        }
        return true;
    }
}
