package com.nitzsch.algorithm.dynamic_programming.bag;

/**
 * https://programmercarl.com/%E8%83%8C%E5%8C%85%E7%90%86%E8%AE%BA%E5%9F%BA%E7%A1%8001%E8%83%8C%E5%8C%85-2
 * .html#%E6%80%BB%E7%BB%93
 *
 * @author: nitzschhong
 * @create: 2022-04-17 11:47
 */
public class BagComplete {

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagSize = 4;
        testWeightBagProblem(weight, value, bagSize);
    }

    /**
     * 01背包 一维数组实现【推荐】
     *
     * @param weight
     * @param value
     * @param bagSize
     */
    public static void testWeightBagProblem(int[] weight, int[] value, int bagSize) {
        int wLen = weight.length;
        //定义dp数组：dp[j]表示背包容量为j时，能获得的最大价值
        int[] dp = new int[bagSize + 1];
        // 遍历顺序：先遍历物品，再遍历背包容量【为什么不能颠倒？debug理解下！】
        for (int i = 0; i < wLen; i++) {
            System.out.println("new thing! i=" + i);
            // 和01背包的差别：背包重量遍历顺序从小到大，因为允许重复
            for (int j = weight[i]; j <= bagSize; j++) {
                System.out.println("new bagSize! bagSize=" + j);
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        //打印dp数组
        for (int j = 0; j <= bagSize; j++) {
            System.out.print(dp[j] + " ");
        }
    }
}
