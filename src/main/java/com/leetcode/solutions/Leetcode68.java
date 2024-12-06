package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

public class Leetcode68 {

    /*
    Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.

    You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

    Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

    For the last line of text, it should be left-justified, and no extra space is inserted between words.

    Note:

    A word is defined as a character sequence consisting of non-space characters only.
    Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
    The input array words contains at least one word.
     */

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> rows = new ArrayList<>();
        List<StringBuilder> wordsInRow = new ArrayList<>();
        int currentLength = 0, wordCount = 0;
        for (int i = 0; i < words.length; i++) {
            boolean canFit = currentLength == 0 ? words[i].length() <= maxWidth
                    : 1 + words[i].length() + currentLength <= maxWidth;
            if (canFit) {
                wordCount++;
                if (currentLength > 0) {
                    wordsInRow.add(new StringBuilder(" "));
                    currentLength++;
                }
                wordsInRow.add(new StringBuilder(words[i]));
                currentLength += words[i].length();
            } else {
                if (wordCount == 1 && currentLength < maxWidth) {
                    wordCount++;
                    wordsInRow.add(new StringBuilder(" "));
                    currentLength++;
                }
                if (currentLength < maxWidth) {
                    int remaining = maxWidth - currentLength;
                    int evenSpace = remaining / (wordCount - 1);
                    int additional = remaining % (wordCount - 1);
                    for (int j = 1; j < wordsInRow.size(); j += 2) {
                        if (additional > 0) {
                            addNSpaces(wordsInRow.get(j), evenSpace + 1);
                            additional--;
                        } else {
                            addNSpaces(wordsInRow.get(j), evenSpace);
                        }
                    }
                }
                rows.add(appendListOfStringBuilder(wordsInRow).toString());
                currentLength = words[i].length();
                wordCount = 1;
                wordsInRow = new ArrayList<>();
                wordsInRow.add(new StringBuilder(words[i]));
            }

            if (i == words.length - 1) {
                int remaining = maxWidth - currentLength;
                if (remaining > 0) {
                    StringBuilder endingSpaces = new StringBuilder();
                    addNSpaces(endingSpaces, remaining);
                    wordsInRow.add(endingSpaces);
                }
                rows.add(appendListOfStringBuilder(wordsInRow).toString());
            }
        }
        return rows;
    }

    private StringBuilder appendListOfStringBuilder(List<StringBuilder> stringBuilders) {
        StringBuilder result = new StringBuilder();
        for (int j = 0; j < stringBuilders.size(); j++) {
            result.append(stringBuilders.get(j));
        }
        return result;
    }

    private void addNSpaces(StringBuilder stringBuilder, int n) {
        int val = 0;
        while (val < n) {
            stringBuilder.append(' ');
            val++;
        }
    }

    public static void main(String[] args) {
        Leetcode68 leetcode68 = new Leetcode68();
        String[] words = new String[] {"This", "is", "an", "example", "of", "text", "justification."};
        System.out.println(leetcode68.fullJustify(words, 16));
    }
}
