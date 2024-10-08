package com.leetcode.solutions;

public class Leetcode121 {

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        Leetcode121 leetcode121 = new Leetcode121();
        System.out.println(leetcode121.maxProfit(prices));
    }
}
