package org.example.c_sliding_window;

public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < minPrice) minPrice = prices[i];
            else {
                int profit = prices[i] - minPrice;

                if(profit > maxProfit) maxProfit = profit;
            }
        }

        return maxProfit;
    }
}
