package com.example.demo.chatgpt.arrays;


public class BestTimeToBuyAndSellStock {
    static void main() {
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] prices) {
        int bprice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < bprice) {
                bprice = prices[i];
            } else if(prices[i] - bprice>maxProfit){
                maxProfit = Math.max(maxProfit, prices[i] - bprice);
            }
        }
        return maxProfit;
    }
}
