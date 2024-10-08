package com.leetcode.solutions;

public class Leetcode55 {

    public boolean canJump(int[] nums) {
        int maxIndex = nums[0];
        for (int i = 1; i <= maxIndex && i < nums.length; i++) {
            maxIndex = Math.max(i + nums[i], maxIndex);
        }
        return maxIndex >= nums.length - 1;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        Leetcode55 leetcode55 = new Leetcode55();
        System.out.println(leetcode55.canJump(nums));
    }
}
