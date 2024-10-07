package com.leetcode.solutions;

public class Leetcode27 {

    public int removeElement(int[] nums, int val) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3, 2, 2, 3};
        Leetcode27 leetcode27 = new Leetcode27();
        System.out.println(leetcode27.removeElement(nums, 3));
    }
}
