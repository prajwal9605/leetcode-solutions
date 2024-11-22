package com.leetcode.solutions;

public class Leetcode135 {

    public int candy(int[] ratings) {
        int n = ratings.length, totalCandies = 0;
        int candies[] = new int[ratings.length];
        for (int i = 0; i < n; i++) {
            candies[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (i + 1 < n && ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                candies[i] = candies[i + 1] + 1;
            }
            totalCandies += candies[i];
        }
        return totalCandies;
    }

    public static void main(String[] args) {
        int ratings[] = new int[] {1, 0, 2};
        Leetcode135 leetcode135 = new Leetcode135();
        System.out.println(leetcode135.candy(ratings));
    }
}
