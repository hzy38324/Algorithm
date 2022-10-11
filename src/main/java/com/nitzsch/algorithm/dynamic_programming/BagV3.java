package com.nitzsch.algorithm.dynamic_programming;

/**
 * https://programmercarl.com/%E8%83%8C%E5%8C%85%E7%90%86%E8%AE%BA%E5%9F%BA%E7%A1%8001%E8%83%8C%E5%8C%85-2
 * .html#%E6%80%BB%E7%BB%93
 *
 * @author: nitzschhong
 * @create: 2022-04-17 11:47
 */
public class BagV3 {

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagSize = 4;
        testWeightBagProblem(weight, value, bagSize);
    }

    public static void testWeightBagProblem(int[] weight, int[] value, int bagSize) {
        int wLen = weight.length;
        //定义dp数组：dp[j]表示背包容量为j时，能获得的最大价值
        int[] dp = new int[bagSize + 1];
        // 遍历顺序：先遍历物品，再遍历背包容量【为什么不能颠倒？debug理解下！】
        for (int i = 0; i < wLen; i++) {
            System.out.println("new thing! i=" + i);
            // 倒序遍历是为了保证物品i只被放入一次！一旦正序遍历了，那么物品0就会被重复加入多次！【为什么不能颠倒？debug理解下！】
            for (int j = bagSize; j >= weight[i]; j--) {
                System.out.println("new bagSize! bagSize=" + j);
                /**
                 * 此时dp[j]有两个选择：一个是取自己dp[j] 相当于 二维dp数组中的dp[i-1][j]，即不放物品i，
                 * 一个是取dp[j - weight[i]] + value[i]，即放物品i，指定是取最大的，毕竟是求最大价值，
                 */
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        //打印dp数组
        for (int j = 0; j <= bagSize; j++) {
            System.out.print(dp[j] + " ");
        }
    }
}
