package com.leetcode.solutions;

public class Leetcode42 {

    public int trap(int[] height) {
        int maxHeightIndex = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i] > height[maxHeightIndex]) {
                maxHeightIndex = i;
            }
        }

        int currentMax = height[0], rainWaterAmount = 0;
        for (int i = 1; i <= maxHeightIndex; i++) {
            if (height[i] > currentMax) {
                currentMax = height[i];
            } else {
                rainWaterAmount += (currentMax - height[i]);
            }
        }

        currentMax = height[height.length - 1];
        for (int i = height.length - 2; i >= maxHeightIndex; i--) {
            if (height[i] > currentMax) {
                currentMax = height[i];
            } else {
                rainWaterAmount += (currentMax - height[i]);
            }
        }
        return rainWaterAmount;
    }

    public static void main(String[] args) {
        int[] height = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        Leetcode42 leetcode42 = new Leetcode42();
        System.out.println(leetcode42.trap(height));
    }
}
