package com.nitzsch.algorithm.recursion.fibonacci;

/**
 * @author: nitzschhong
 * @create: 2022-03-12 10:30
 */
public class Solution {

    public int Fibonacci(int n) {
        /*
         * 时间复杂度：
         * 空间复杂度：O(n) 递归栈的深度
         */
        if (n == 1 || n == 2) {
            return 1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);

        /*
         * 优化方式1：使用map或者数组，减少重复计算
         * 优化方式2：动态规划
         * 参考： https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3
         */
    }

}
