package com.example.demo.chatgpt.recursion;

import java.util.Arrays;

public class ReverseString {
    static void main(String[] args) {
        char[] c={'h','e','l','l','o'};
        reverseString(c);
        System.out.println(Arrays.toString(c));
    }

    public static void reverseString(char[] s) {
         if (s.length==1){
             return;
         }
        swap(s,0,s.length-1);
    }

    public static void swap(char[] s,int start,int end){
        if(start>=end){
            return;
        }
        char temp=s[start];
        s[start]=s[end];
        s[end]=temp;
        swap(s,++start,--end);
    }
}
