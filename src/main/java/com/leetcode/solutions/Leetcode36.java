package com.leetcode.solutions;

public class Leetcode36 {
    /*
    Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

    Each row must contain the digits 1-9 without repetition.
    Each column must contain the digits 1-9 without repetition.
    Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
    Note:

    A Sudoku board (partially filled) could be valid but is not necessarily solvable.
    Only the filled cells need to be validated according to the mentioned rules.
     */

    public boolean isValidSudoku(char[][] board) {
        boolean isValid = true;
        outer1:
        for (int i = 0; i < 9; i++) {
            boolean[] digitsPresentInRow = new boolean[10];
            boolean[] digitsPresentInColumn = new boolean[10];
            for (int j = 0; j < 9; j++) {
                int row = i, column = j;
                if (board[row][column] != '.') {
                    int digit = board[row][column] - '0';
                    if (!digitsPresentInRow[digit]) {
                        digitsPresentInRow[digit] = true;
                    } else {
                        isValid = false;
                        break outer1;
                    }
                }

                column = i;
                row = j;
                if (board[row][column] != '.') {
                    int digit = board[row][column] - '0';
                    if (!digitsPresentInColumn[digit]) {
                        digitsPresentInColumn[digit] = true;
                    } else {
                        isValid = false;
                        break outer1;
                    }
                }
            }
        }
        if (!isValid) {
            return isValid;
        }

        int[][] range = new int[][]{{0, 2}, {3, 5}, {6, 8}};
        outer2:
        for (int i = 0; i < range.length; i++) {
            for (int j = 0; j < range.length; j++) {
                boolean[] digitsPresentInGrid = new boolean[10];
                for (int r = range[i][0]; r <= range[i][1]; r++) {
                    for (int c = range[j][0]; c <= range[j][1]; c++) {
                        if (board[r][c] != '.') {
                            int digit = board[r][c] - '0';
                            if (!digitsPresentInGrid[digit]) {
                                digitsPresentInGrid[digit] = true;
                            } else {
                                isValid = false;
                                break outer2;
                            }
                        }
                    }
                }
            }
        }
        return isValid;
    }

    /*
    Solution:
    Space complexity O(m*n) where m and n are the dimensions of the board.
    Time complexity O(m*n)
     */

    public static void main(String[] args) {
        Leetcode36 leetcode36 = new Leetcode36();
        char[][] board = {{'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}};
        System.out.println(leetcode36.isValidSudoku(board));
    }
}
