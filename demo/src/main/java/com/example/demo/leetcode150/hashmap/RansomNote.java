package com.example.demo.leetcode150.hashmap;

import java.util.HashMap;

public class RansomNote {
    static void main(String[] args) {
        System.out.println(canConstruct("aa","ab"));
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> map = new HashMap<>();

        for (char c : magazine.toCharArray()){
            map.put( c, map.getOrDefault(c, 0) + 1 );
        }

        for ( char c : ransomNote.toCharArray() ){
            int count = map.getOrDefault(c,0);
            if (count == 0) return false;
            map.put(c, count -1);
        }
        return true;

    }
}
