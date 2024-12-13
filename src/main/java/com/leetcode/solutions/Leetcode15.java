package com.leetcode.solutions;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Leetcode15 {

    /*
    Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

    Notice that the solution set must not contain duplicate triplets.
     */

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i - 1 >= 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    result.add(List.of(nums[i], nums[j], nums[k]));
                    while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    while (k - 1 >= 0 && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    j++;
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Leetcode15 leetcode15 = new Leetcode15();
        System.out.println(leetcode15.threeSum(new int[]{0, 1, -1, 5, 0, 0, 2, 3, 2, -4}));
    }
}
