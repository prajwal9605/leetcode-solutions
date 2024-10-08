package com.leetcode.solutions;

public class Leetcode80 {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0, n = nums.length;
        while (j < n) {
            int count = 1;
            while (j + 1 < n && nums[j] == nums[j + 1]) {
                j++;
                count++;
            }
            count = Math.min(count, 2);
            while (count > 0) {
                nums[i] = nums[j];
                i++;
                count--;
            }
            j++;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,1,1,2,2,3};
        Leetcode80 leetcode80 = new Leetcode80();
        int k = leetcode80.removeDuplicates(nums);
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
