package com.example.demo.chatgpt.bitmanipulation;

public class FindIfNumIsPowerOf2 {

    static void main(String[] args) {
        int n = 32;
        boolean flag = (n & (n-1)) == 0;
        System.out.println(flag);
    }

    //Code logic
    //All powers of 2 have only one set bit in it
    //2^0 = 1     BINARY:- 0001
    //2^1 = 2     BINARY:- 0010
    //2^2 = 4     BINARY:- 0100
    //2^3 = 8     BINARY:- 1000
    //Here we can observe that all the nums have only one set bit in their binary representation
    //When we do (n & n-1) then if it leads to 0 then we can assume that the number is power of two
    // For example
    // Let's take n = 8
    // n     = 1000   (8)
    // n - 1 = 0111   (7)
    //Now perform the AND operation:
    // Result - 0000
}
