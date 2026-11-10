package com.example.demo.chatgpt.strings.twopointers;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i = 0; i< s.length(); i++) {
            count += counts(s, i, i);
            count += counts(s, i, i + 1);
        }
        return count;
    }

    public int counts(String s, int left, int right) {
        int c = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            c++;
            left--;
            right++;
        }
        return c;
    }
}
