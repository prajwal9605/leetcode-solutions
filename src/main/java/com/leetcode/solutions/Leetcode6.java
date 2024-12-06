package com.leetcode.solutions;

public class Leetcode6 {

    /*
    The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

    P   A   H   N
    A P L S I I G
    Y   I   R
    And then read line by line: "PAHNAPLSIIGYIR"

    Write the code that will take a string and make this conversion given a number of rows:

    string convert(string s, int numRows);
     */

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] arr = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            arr[i] = new StringBuilder();
        }
        int index = 0;
        boolean increasing = true;
        for (int i = 0; i < s.length(); i++) {
            arr[index].append(s.charAt(i));
            if (index == numRows - 1) {
                increasing = false;
            } else if (index == 0) {
                increasing = true;
            }
            if (increasing) {
                index++;
            } else {
                index--;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            result.append(arr[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Leetcode6 leetcode6 = new Leetcode6();
        String s = "PAYPALISHIRING";
        System.out.println(leetcode6.convert(s, 3));
    }
}
