package com.leetcode.solutions;

public class Leetcode125 {

    /*
    A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

    Given a string s, return true if it is a palindrome, or false otherwise.
     */

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        boolean palindrome = true;
        while (i < j) {
            while (i < s.length() && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (j >= 0 && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (i < j) {
                palindrome = Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j));
                if (!palindrome) {
                    break;
                }
                i++;
                j--;
            }
        }
        return palindrome;
    }

    public static void main(String[] args) {
        Leetcode125 leetcode125 = new Leetcode125();
        System.out.println(leetcode125.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
