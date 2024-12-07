package com.leetcode.solutions;

public class Leetcode11 {

    /*
    You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

    Find two lines that together with the x-axis form a container, such that the container contains the most water.

    Return the maximum amount of water a container can store.

    Notice that you may not slant the container.
     */

    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int maxWater = 0;
        while (i < j) {
            int min = Math.min(height[i], height[j]);
            int water = (j - i) * min;
            if (water > maxWater) {
                maxWater = water;
            }
            if (height[i] < height[j]) {
                while (i < height.length && height[i] <= min) {
                    i++;
                }
            } else {
                while (j >= 0 && height[j] <= min) {
                    j--;
                }
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        Leetcode11 leetcode11 = new Leetcode11();
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(leetcode11.maxArea(height));
    }
}
