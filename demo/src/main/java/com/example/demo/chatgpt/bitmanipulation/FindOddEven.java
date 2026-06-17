package com.example.demo.chatgpt.bitmanipulation;

public class FindOddEven {
    static void main(String[] args) {
        System.out.println(findOddEven(21));
        System.out.println(findOddEven(22));
    }

    private static String findOddEven(int n) {
    boolean flag = (n & 1) == 0;
    return flag ? "Even" : "Odd";
    }


}
