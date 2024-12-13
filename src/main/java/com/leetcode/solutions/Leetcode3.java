package com.leetcode.solutions;

import java.util.HashSet;
import java.util.Set;

public class Leetcode3 {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0, length, maxLength = 0;
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                if (j == s.length() - 1) {
                    length = j - i + 1;
                    if (length > maxLength) {
                        maxLength = length;
                    }
                }
                j++;
            } else {
                char current = s.charAt(j);
                length = j - i;
                if (length > maxLength) {
                    maxLength = length;
                }
                while (s.charAt(i) != current) {
                    set.remove(s.charAt(i));
                    i++;
                }
                i++;
                j++;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Leetcode3 leetcode3 = new Leetcode3();
        System.out.println(leetcode3.lengthOfLongestSubstring("abcabcbb"));
    }
}
