package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

public class Leetcode54 {

    /*
    Given an m x n matrix, return all elements of the matrix in spiral order.
    Example 1:
    Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
    Output: [1,2,3,6,9,8,7,4,5]
    Example 2:
    Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
    Output: [1,2,3,4,8,12,11,10,9,5,6,7]
     */

    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length, columns = matrix[0].length, i = 0, j = 0, count = 0;
        boolean[][] visited = new boolean[rows][columns];
        List<Integer> result = new ArrayList<>();
        result.add(matrix[i][j]);
        visited[i][j] = true;
        count++;
        while (count < rows * columns) {
            while (j + 1 < columns && !visited[i][j + 1]) {
                result.add(matrix[i][j + 1]);
                visited[i][j + 1] = true;
                j++;
                count++;
            }
            while (i + 1 < rows && !visited[i + 1][j]) {
                result.add(matrix[i + 1][j]);
                visited[i + 1][j] = true;
                i++;
                count++;
            }
            while (j - 1 >= 0 && !visited[i][j - 1]) {
                result.add(matrix[i][j - 1]);
                visited[i][j - 1] = true;
                j--;
                count++;
            }
            while (i - 1 >= 0 && !visited[i - 1][j]) {
                result.add(matrix[i - 1][j]);
                visited[i - 1][j] = true;
                i--;
                count++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Leetcode54 leetcode54 = new Leetcode54();
        System.out.println(leetcode54.spiralOrder(new int[][] {{1, 2, 3,}, {4, 5, 6}, {7, 8, 9}}));
    }
}
