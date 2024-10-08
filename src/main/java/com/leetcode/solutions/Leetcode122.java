package com.leetcode.solutions;

public class Leetcode122 {

    public int maxProfit(int[] prices) {
        int i = 0, n = prices.length;
        int profit = 0;
        while (i < n) {
            while (i + 1 < n && prices[i] >= prices[i + 1]) {
                i++;
            }
            int buyPrice = prices[i];
            while (i + 1 < n && prices[i] < prices[i + 1]) {
                i++;
            }
            int sellPrice = prices[i];
            profit += (sellPrice - buyPrice);
            i++;
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        Leetcode122 leetcode122 = new Leetcode122();
        System.out.println(leetcode122.maxProfit(prices));
    }
}
