package com.nitzsch.algorithm.dynamic_programming.bag;

/**
 * https://programmercarl.com/%E8%83%8C%E5%8C%85%E7%90%86%E8%AE%BA%E5%9F%BA%E7%A1%8001%E8%83%8C%E5%8C%85-2
 * .html#%E6%80%BB%E7%BB%93
 *
 * @author: nitzschhong
 * @create: 2022-04-17 11:47
 */
public class Bag_01_V2 {

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
        // 定义dp数组：dp[j]表示背包容量为j时，能获得的最大价值
        int[] dp = new int[bagSize + 1];

        // 初始化
        // 默认是0，无需写初始化代码

        /**
         * 这道题的图解 可以参考 flomo https://v.flomoapp.com/mine/?memo_id=NDM4ODM5MDc
         */
        // 遍历顺序：先遍历物品，再遍历背包容量【为什么不能颠倒？debug理解下！】
        for (int i = 0; i < wLen; i++) {
            // 倒序遍历是为了保证物品i只被放入一次！一旦正序遍历了，那么物品0就会被重复加入多次！【为什么不能颠倒？debug理解下！】
            for (int j = bagSize; j >= weight[i]; j--) {
                /**
                 * 此时dp[j]有两个选择：一个是取自己dp[j] 相当于 二维dp数组中的dp[i-1][j]，即不放物品i，
                 * 一个是取dp[j - weight[i]] + value[i]，即放物品i，指定是取最大的，毕竟是求最大价值，
                 */
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
                print(bagSize, dp);
            }
            // 正序遍历，会出现重复拿物品，不适用于01背包，会导致最后结果比正确结果大！
            // 原因：背包大小从小到大遍历，那么小背包的dp已经是拿了物品的计算结果，结合递归公式，大背包依赖了小背包的结果，所以会重复拿物品
//            for (int j = weight[i]; j <= bagSize; j++) {
//                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
//                print(bagSize, dp);
//            }
            System.out.println("======");
        }
        print(bagSize, dp);
    }

    private static void print(int bagSize, int[] dp) {
        for (int j = 0; j <= bagSize; j++) {
            System.out.print(dp[j] + " ");
        }
        System.out.println();
    }
}
