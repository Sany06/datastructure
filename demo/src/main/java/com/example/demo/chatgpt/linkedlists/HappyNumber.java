package com.example.demo.chatgpt.linkedlists;

//https://leetcode.com/problems/happy-number/description/
public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {
        int slow=n;
        int fast=n;
        do{
            slow= sumOfSquareOfDigits(slow);
            fast = sumOfSquareOfDigits(sumOfSquareOfDigits(fast));
        } while(slow!=fast);
        return slow == 1;
    }

    public static int sumOfSquareOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            int rem = n % 10;
            sum += (rem * rem);
            n = n / 10;
        }
        return sum;
    }
}
