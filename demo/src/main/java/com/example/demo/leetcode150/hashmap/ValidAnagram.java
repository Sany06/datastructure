package com.example.demo.leetcode150.hashmap;

import java.util.Arrays;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a,b);
    }
}
