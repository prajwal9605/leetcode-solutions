package com.leetcode.solutions;

public class Leetcode167 {

    /*
    Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

    Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

    The tests are generated such that there is exactly one solution. You may not use the same element twice.

    Your solution must use only constant extra space.
     */

    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        int result[] = new int[2];
        while (i < j) {
            if (numbers[i] + numbers[j] < target) {
                i++;
            } else if (numbers[i] + numbers[j] > target) {
                j--;
            } else if (numbers[i] + numbers[j] == target) {
                result[0] = i + 1;
                result[1] = j + 1;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Leetcode167 leetcode167 = new Leetcode167();
        int[] num = new int[] {2,7,11,15};
        int[] result = leetcode167.twoSum(num, 9);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
