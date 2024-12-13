package com.leetcode.solutions;

public class Leetcode209 {
    /*
    Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
     */

    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0, sum = 0, minLength = Integer.MAX_VALUE;
        while (j < nums.length) {
            sum += nums[j];
            if (sum < target) {
                j++;
            } else {
                while (sum - nums[i] >= target) {
                    sum -= nums[i];
                    i++;
                }
                int length = j - i + 1;
                if (length < minLength) {
                    minLength = length;
                }
                j++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        Leetcode209 leetcode209 = new Leetcode209();
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        System.out.println(leetcode209.minSubArrayLen(7, nums));
    }
}
