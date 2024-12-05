package com.leetcode.solutions;

public class Leetcode14 {

    /*
    Write a function to find the longest common prefix string amongst an array of strings.

    If there is no common prefix, return an empty string "".
     */

    public String longestCommonPrefix(String[] strs) {
        StringBuilder commonPrefix = new StringBuilder();
        outer:
        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != ch) {
                    break outer;
                }
            }
            commonPrefix.append(ch);
        }
        return commonPrefix.toString();
    }

    public static void main(String[] args) {
        Leetcode14 leetcode14 = new Leetcode14();
        String[] strs = new String[]{"flower", "flow", "flight"};
        System.out.println(leetcode14.longestCommonPrefix(strs));
    }
}
