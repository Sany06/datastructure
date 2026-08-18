package com.example.demo.chatgpt.recursion.string;

import java.util.ArrayList;
import java.util.List;

public class SubSet {
    static void main(String[] args) {
        String s = "abc";
        //System.out.println(subset("", s, new ArrayList<>()));
        System.out.println(subset1("",s));
    }

    static List<String> subset(String processed, String unprocessed, List<String> list) {
        if (unprocessed.isEmpty()) {
            list.add(processed);
            return list;
        }
        char ch = unprocessed.charAt(0);
        subset(processed + ch, unprocessed.substring(1), list);
        subset(processed, unprocessed.substring(1), list);
        return list;
    }

    static List<String> subset1(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        char ch = unprocessed.charAt(0);
        List<String> left = subset1(processed + ch, unprocessed.substring(1));
        List<String> right = subset1(processed, unprocessed.substring(1));
        left.addAll(right);
        return left;
    }
}
