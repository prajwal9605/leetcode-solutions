package com.leetcode.solutions;

import java.util.Arrays;

public class Leetcode88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = m + n - 1, k = 0;
        while (i >= 0) {
            nums1[j] = nums1[i];
            j--;
            i--;
        }

        i = n;
        j = 0;
        while (i < m + n && j < n) {
            if (nums1[i] <= nums2[j]) {
                nums1[k] = nums1[i];
                i++;
                k++;
            } else {
                nums1[k] = nums2[j];
                k++;
                j++;
            }
        }
        while (i < m + n) {
            nums1[k] = nums1[i];
            i++;
            k++;
        }
        while (j < n) {
            nums1[k] = nums2[j];
            k++;
            j++;
        }
    }

    public static void main(String[] args) {
        int nums1[] = {1, 2, 4, 5, 6, 0};
        int nums2[] = {3};
        Leetcode88 leetcode88 = new Leetcode88();
        leetcode88.merge(nums1, 5, nums2, 1);
        Arrays.stream(nums1).forEach(System.out::println);
    }
}
