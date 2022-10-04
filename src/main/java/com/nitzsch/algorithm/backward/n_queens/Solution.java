package com.nitzsch.algorithm.backward.n_queens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: nitzschhong
 * @create: 2022-09-27 21:40
 */
public class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        backTrack(n, 0, chessboard);
        return res;
    }


    public void backTrack(int n, int row, char[][] chessboard) {
        if (row == n) {
            res.add(Array2List(chessboard));
            return;
        }

        // 横向遍历：尝试每行不同位置摆放皇后
        for (int col = 0; col < n; ++col) {
            if (isValid(row, col, n, chessboard)) {
                // 把皇后放上去
                chessboard[row][col] = 'Q';
                // 纵向遍历：下一行
                backTrack(n, row + 1, chessboard);
                // 撤销操作：把皇后挪走
                chessboard[row][col] = '.';
            }
        }

    }


    public List Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();

        for (char[] c : chessboard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }


    public boolean isValid(int row, int col, int n, char[][] chessboard) {
        // 检查列
        for (int i = 0; i < row; ++i) { // 相当于剪枝
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        // 检查45度对角线，因为回溯算法的遍历顺序是从上往下的，所以只需要检查上方（i--）的
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        // 检查135度对角线，同上
        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
