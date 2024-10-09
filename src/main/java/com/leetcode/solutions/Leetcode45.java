package com.leetcode.solutions;

public class Leetcode45 {

    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int jumps = 1, i = 0, maxIndex = nums[0];
        while (maxIndex < nums.length - 1) {
            int nextMaxIndex = maxIndex;
            while (i <= maxIndex) {
                nextMaxIndex = Math.max(nextMaxIndex, i + nums[i]);
                i++;
            }
            maxIndex = nextMaxIndex;
            jumps++;
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,3,1,1,4};
        Leetcode45 leetcode45 = new Leetcode45();
        System.out.println(leetcode45.jump(nums));
    }
}
