package com.nitzsch.algorithm.array.luoxuan_arr;

/**
 * @author: nitzschhong
 * @create: 2022-08-03 23:39
 */
public class LuoXuan {
    public static void main(String[] args) {
        int[][] ints = new LuoXuan().generateMatrix(3);
        System.out.println(ints);
    }

    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int i = 0;
        int j = 0;
        int count = 1;
        while (true) {
            while (true) {
                arr[i][j] = count;
                count++;
                if (j == n - 1 || arr[i][j + 1] != 0) {
                    i++;
                    break;
                }
                j++;
            }
            if (count > n * n) break;
            while (true) {
                arr[i][j] = count;
                count++;
                if (i == n - 1 || arr[i + 1][j] != 0) {
                    j--;
                    break;
                }
                i++;
            }
            if (count > n * n) break;
            while (true) {
                arr[i][j] = count;
                count++;
                if (j == 0 || arr[i][j - 1] != 0) {
                    i--;
                    break;
                }
                j--;
            }
            if (count > n * n) break;
            while (true) {
                arr[i][j] = count;
                count++;
                if (i == 0 || arr[i - 1][j] != 0) {
                    j++;
                    break;
                }
                i--;
            }
            if (count > n * n) break;
        }
        return arr;

    }
}
