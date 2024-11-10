package com.leetcode.solutions;

public class Leetcode238 {

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int suffixProduct = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            suffixProduct = suffixProduct * nums[i + 1];
            result[i] = result[i] * suffixProduct;
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{1, 2, 3, 4};
        Leetcode238 leetcode238 = new Leetcode238();
        int result[] = leetcode238.productExceptSelf(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
