package com.example.demo.chatgpt.bitmanipulation;

public class FindIfNumIsPowerOf2 {

    static void main(String[] args) {
        int n = 32;
        boolean flag = (n & (n-1)) == 0;
        System.out.println(flag);
    }
}
