package com.nitzsch.algorithm.dynamic_programming.base;

/**
 * @author: nitzschhong
 * @create: 2022-10-29 10:51
 */
public class Fibonacci {

    public static void main(String[] args) {
        new Fibonacci().fib(10);
    }

    public int fib(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
