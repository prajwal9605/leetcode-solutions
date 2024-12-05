package com.leetcode.solutions;

public class Leetcode58 {

    /*
    Given a string s consisting of words and spaces, return the length of the last word in the string.

    A word is a maximal substring consisting of non-space characters only.
     */

    public int lengthOfLastWord(String s) {
        s = s.trim();
        return s.length() - s.lastIndexOf(' ') - 1;
    }

    public static void main(String[] args) {
        Leetcode58 leetcode58 = new Leetcode58();
        System.out.println(leetcode58.lengthOfLastWord("   fly me   to   the moon  "));
    }
}
