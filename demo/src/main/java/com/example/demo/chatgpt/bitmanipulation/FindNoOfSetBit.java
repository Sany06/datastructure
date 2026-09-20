package com.example.demo.chatgpt.bitmanipulation;

public class FindNoOfSetBit {
    static void main() {
        System.out.println(findNoOfSetBit(1011));
    }
    //Note : When we do n & (n - 1) it removes the rightmost set bit
    //repeatedly do n & (n - 1) → each (n & (n- 1)) removes the rightmost 1 → number of operations = number of set bits.
    private static int findNoOfSetBit(int n){
        n = Integer.parseInt(String.valueOf(n), 2);
        int count = 0;

        while (n > 0) {
            count++;
            n = n & (n-1);
        }
        return count;
    }
}
