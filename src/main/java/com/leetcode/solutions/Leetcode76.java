package com.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

public class Leetcode76 {

    /*
    Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every
    character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
    The testcases will be generated such that the answer is unique.
     */

    public String minWindow(String s, String t) {
        int i = 0, j = 0, minLength = Integer.MAX_VALUE;
        String result = "";
        Map<Character, Integer> expectedMap = new HashMap<>();
        for (i = 0; i < t.length(); i++) {
            expectedMap.put(t.charAt(i), expectedMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        Map<Character, Integer> remainingMap = new HashMap<>(expectedMap);
        Map<Character, Integer> windowMap = new HashMap<>();
        i = 0;
        while (j < s.length()) {
            while (j < s.length() && !remainingMap.isEmpty()) {
                if (remainingMap.containsKey(s.charAt(j))) {
                    decreaseCharCount(remainingMap, s.charAt(j));
                }
                windowMap.put(s.charAt(j), windowMap.getOrDefault(s.charAt(j), 0) + 1);
                if (!remainingMap.isEmpty()) {
                    j++;
                }
            }
            if (!remainingMap.isEmpty()) {
                break;
            }
            while (i < j && windowMap.get(s.charAt(i)) > expectedMap.getOrDefault(s.charAt(i), 0)) {
                decreaseCharCount(windowMap, s.charAt(i));
                i++;
            }
            int length = j - i + 1;
            if (length < minLength) {
                minLength = length;
                result = s.substring(i, j + 1);
            }
            remainingMap.put(s.charAt(i), 1);
            decreaseCharCount(windowMap, s.charAt(i));
            i++;
            j++;
        }
        return result;
    }

    private void decreaseCharCount(Map<Character, Integer> map, char ch) {
        int count = map.get(ch);
        if (count > 1) {
            map.put(ch, count - 1);
        } else {
            map.remove(ch);
        }
    }

    public static void main(String[] args) {
        Leetcode76 leetcode76 = new Leetcode76();
        System.out.println(leetcode76.minWindow("ADOBECODEBANC", "ABC")); // "BANC"
    }
}
