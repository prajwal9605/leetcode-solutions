package com.leetcode.solutions;

public class Leetcode42 {

    /*
    Trapping Rain Water
    Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
    Example 1:
    Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
    Output: 6
    Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
    Example 2:
    Input: height = [4,2,0,3,2,5]
    Output: 9
     */

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
