package com.example.demo.chatgpt.recursion.string;

public class SkipACharacter {

    static void main(String[] args) {
        String s = "baccad";
        System.out.println(skipCharacter(s, 'a', 0, new StringBuilder()));
    }

    static String skipCharacter(String s, char a, int index, StringBuilder sb) {
        if (index == s.length()) {
            return sb.toString();
        }
        if (s.charAt(index) != a) {
            sb.append(s.charAt(index));
            return skipCharacter(s, a, index + 1, sb);
        }
        return skipCharacter(s, a, index + 1, sb);
    }
}
