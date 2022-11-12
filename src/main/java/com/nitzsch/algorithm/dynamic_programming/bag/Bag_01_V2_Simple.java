package com.nitzsch.algorithm.dynamic_programming.bag;

/**
 * 01背包【无注释版】 一维数组实现【推荐】
 * https://programmercarl.com/%E8%83%8C%E5%8C%85%E7%90%86%E8%AE%BA%E5%9F%BA%E7%A1%8001%E8%83%8C%E5%8C%85-2
 * .html#%E6%80%BB%E7%BB%93
 *
 * @author: nitzschhong
 * @create: 2022-04-17 11:47
 */
public class Bag_01_V2_Simple {

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagSize = 4;
        testWeightBagProblem(weight, value, bagSize);
    }

    public static void testWeightBagProblem(int[] weight, int[] value, int bagSize) {
        int wLen = weight.length;
        int[] dp = new int[bagSize + 1];
        for (int i = 0; i < wLen; i++) {
            for (int j = bagSize; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
    }
}
