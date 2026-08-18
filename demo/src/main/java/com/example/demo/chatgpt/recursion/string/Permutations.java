package com.example.demo.chatgpt.recursion.string;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    static void main(String[] args) {
        System.out.println(permutations("", "abc"));
        //System.out.println(permutations("", "abc"));
        //System.out.println(permutationsCount("", "abc"));
    }

    public List<String> permutations(String p, String up, List<String> list) {
        if(up.isEmpty()){
            list.add(p);
            return list;
        }
        //Take one character from up
        char ch = up.charAt(0);
        //Insert it at every possible position in p
        for(int i = 0; i <= p.length(); i++) {
            String f = p.substring(0,i);
            String s = p.substring(i);
            permutations(f + ch + s, up.substring(1), list);  //Recursively process the remaining characters
        }
        return list;
    }

    static List<String> permutations(String p, String up) {
        if (up.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);

        List<String> list = new ArrayList<>();

        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0,i);
            String s = p.substring(i,p.length());
            list.addAll(permutations(f + ch + s, up.substring(1)));
        }
        return list;
    }

    static int permutationsCount(String p, String up) {
        if (up.isEmpty()) {
            return 1;
        }
        char ch = up.charAt(0);

        int count=0;

        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0,i);
            String s = p.substring(i,p.length());
            count=count + permutationsCount(f + ch + s, up.substring(1));
        }

        return count;

    }
}
