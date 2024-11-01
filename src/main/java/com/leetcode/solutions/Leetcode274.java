package com.leetcode.solutions;

public class Leetcode274 {

    public int hIndex(int[] citations) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < citations.length; i++) {
            max = Math.max(max, citations[i]);
        }
        int occurences[] = new int[max + 1];
        for (int i = 0; i < citations.length; i++) {
            occurences[citations[i]]++;
        }
        int sum = 0, res = 0;
        for (int i = max; i >= 1; i--) {
            sum += occurences[i];
            if (sum >= i) {
                res = i;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] citations = new int[] {3,0,6,1,5};
        Leetcode274 leetcode274 = new Leetcode274();
        System.out.println(leetcode274.hIndex(citations));
    }
}
