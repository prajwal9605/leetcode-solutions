package com.leetcode.solutions;

public class Leetcode26 {

    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0, n = nums.length;
        while (j < n) {
            while (j+1 < n && nums[j] == nums[j+1]) {
                j++;
            }
            nums[i] = nums[j];
            i++;
            j++;
        }
        return i;
    }

    public static void main(String[] args) {
        Leetcode26 leetcode26 = new Leetcode26();
        int[] nums = new int[] {0,0,1,1,1,2,2,3,3,4};
        int k = leetcode26.removeDuplicates(nums);
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
