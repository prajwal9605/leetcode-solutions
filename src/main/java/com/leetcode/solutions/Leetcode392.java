package com.leetcode.solutions;

public class Leetcode392 {

    /*
    Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

    A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
     */

    public boolean isSubsequence(String s, String t) {
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            while (j < t.length() && t.charAt(j) != ch) {
                j++;
            }
            if (j >= t.length()) {
                return false;
            } else {
                j++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Leetcode392 leetcode392 = new Leetcode392();
        System.out.println(leetcode392.isSubsequence("abc", "ahbgdc"));
    }
}
