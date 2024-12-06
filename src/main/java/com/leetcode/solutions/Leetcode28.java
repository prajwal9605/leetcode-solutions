package com.leetcode.solutions;

public class Leetcode28 {

    /*
    Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     */

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        Leetcode28 leetcode28 = new Leetcode28();
        System.out.println(leetcode28.strStr("sadbutsad", "sad"));
    }
}
