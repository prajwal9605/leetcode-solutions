package com.leetcode.solutions;

public class Leetcode12 {

    /*
    Seven different symbols represent Roman numerals with the following values:

    Symbol	Value
    I	1
    V	5
    X	10
    L	50
    C	100
    D	500
    M	1000
    Roman numerals are formed by appending the conversions of decimal place values from highest to lowest. Converting a decimal place value into a Roman numeral has the following rules:

    If the value does not start with 4 or 9, select the symbol of the maximal value that can be subtracted from the input, append that symbol to the result, subtract its value, and convert the remainder to a Roman numeral.
    If the value starts with 4 or 9 use the subtractive form representing one symbol subtracted from the following symbol, for example, 4 is 1 (I) less than 5 (V): IV and 9 is 1 (I) less than 10 (X): IX. Only the following subtractive forms are used: 4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) and 900 (CM).
    Only powers of 10 (I, X, C, M) can be appended consecutively at most 3 times to represent multiples of 10. You cannot append 5 (V), 50 (L), or 500 (D) multiple times. If you need to append a symbol 4 times use the subtractive form.
    Given an integer, convert it to a Roman numeral.
     */

    public String intToRoman(int num) {
        int numbers[] = {1000, 100, 10, 1};
        char symbol[] = {'M', 'C', 'X', 'I'};
        String[][] subtractive = new String[4][10];
        subtractive[1][4]= "CD";
        subtractive[1][9]= "CM";
        subtractive[1][5] = "D";
        subtractive[2][4]= "XL";
        subtractive[2][9]= "XC";
        subtractive[2][5] = "L";
        subtractive[3][4] = "IV";
        subtractive[3][9] = "IX";
        subtractive[3][5] = "V";
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            int quotient = num / numbers[i];
            if (quotient == 4 || quotient == 9) {
                roman.append(subtractive[i][quotient]);
                num -= (quotient * numbers[i]);
            } else {
                if (quotient >= 5) {
                    roman.append(subtractive[i][5]);
                    num -= (5 * numbers[i]);
                }
                while (num >= numbers[i]) {
                    roman.append(symbol[i]);
                    num -= numbers[i];
                }
            }
        }
        return roman.toString();
    }

    public static void main(String[] args) {
        Leetcode12 leetcode12 = new Leetcode12();
        System.out.println(leetcode12.intToRoman(3749));
    }
}
