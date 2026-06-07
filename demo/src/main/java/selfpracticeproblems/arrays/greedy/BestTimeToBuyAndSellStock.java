package selfpracticeproblems.arrays.greedy;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int bprice = prices[0];
        int maxprofit = 0;
        for (int p : prices) {
            if (p < bprice) {
                bprice = p;
                continue;
            } else {
                maxprofit = Math.max(maxprofit, p - bprice);
            }
        }
        return maxprofit;
    }
}
