package com.example.demo.chatgpt.bitmanipulation;

public class FindPositionOfRightmostSetBit {
    static void main(String[] args) {
        System.out.println(findPositionOfRightMostSetBit(1100));
    }

    //This problem is also known as least significant set bit
    private static int findPositionOfRightMostSetBit(int n) {
        int val = n & -n; // We are doing this to isolate the rightmost set bit i.e
                         // n & -n removes all bits except the rightmost set bit
        //return Integer.numberOfTrailingZeros(val);
        int pos = 0;
        while ( val > 1) {
            pos++;
            val = val >> 1;
        }
        return pos;
    }
}
