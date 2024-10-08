package com.leetcode.solutions;

public class Leetcode169 {
    public int majorityElement(int[] nums) {
        int count = 0, num = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                num = nums[i];
                count++;
            } else if (nums[i] == num) {
                count++;
            } else {
                count--;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,2,1,1,1,2,2};
        Leetcode169 leetcode169 = new Leetcode169();
        System.out.println(leetcode169.majorityElement(nums));
    }
}
