package com.leetcode.solutions;

public class Leetcode189 {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        reverse(nums, 0, n-k-1);
        reverse(nums, n-k, n-1);
        reverse(nums, 0, n-1);
    }

    private void reverse(int[] nums, int beg, int end) {
        while (beg < end) {
            int temp = nums[beg];
            nums[beg] = nums[end];
            nums[end] = temp;
            beg++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4,5,6,7};
        Leetcode189 leetcode189 = new Leetcode189();
        leetcode189.rotate(nums, 3);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
