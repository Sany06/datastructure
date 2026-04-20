package com.example.demo.chatgpt.binarysearch.binarysearchonanswers;

public class SquareRootOfX {

    public int mySqrt(int x) {
        int start = 0;
        int end = x;

        int result = 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            long square = (long) mid * mid;


            if (square == x) {
                return mid;
            }
            if (square < x) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }
}
