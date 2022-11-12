package com.nitzsch.algorithm.dynamic_programming.bag;

/**
 * 多维度 01背包
 * https://www.programmercarl.com/0474.%E4%B8%80%E5%92%8C%E9%9B%B6.html#%E6%80%9D%E8%B7%AF
 *
 * @author: nitzschhong
 * @create: 2022-04-17 11:47
 */
public class Bag_01_duowei {

    public static void main(String[] args) {
        String[] strs = new String[]{"10", "0001", "111001", "1", "0"};
        findMaxForm(strs, 5, 3);
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int oneNum = 0, zeroNum = 0;
            char[] charArr = str.toCharArray();
            for (char c : charArr) {
                if (c == '0') zeroNum++;
                else oneNum++;
            }
            // 和一维01背包的差别，仅仅在于这里需要两重循环
            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }
        print2D(dp);
        return dp[m][n];
    }

    public static void print2D(int mat[][]) {
        // Loop through all rows
        for (int i = 0; i < mat.length; i++){
            // Loop through all elements of current row
            for (int j = 0; j < mat[i].length; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("");
        }

    }
}
