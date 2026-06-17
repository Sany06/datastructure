package com.example.demo.chatgpt.bitmanipulation;

public class FindithBitOfANum {

    static void main(String[] args) {
        int n = 10; // 1010
        int i = 3;  //1
        System.out.println(getIthBit(n,i));
    }
    // For finding the ith bit we have to follow 2 steps
    // Step-1 : We have to RightShift the num i times
            //Example - if we do >> of 1010 1 time then
            // Binary form of 10 is 1010
            // After right shifting 1 time 0101
    //Step-2 : Now & 1 to get the ith bit, as if we &1 a num we get that bit itself
    public static int getIthBit(int n , int i) {
        return (n >> i) & 1;
    }
}
