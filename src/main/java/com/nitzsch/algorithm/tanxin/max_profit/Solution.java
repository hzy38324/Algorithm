package com.nitzsch.algorithm.tanxin.max_profit;

/**
 * @author: nitzschhong
 * @create: 2022-09-30 08:08
 */
public class Solution {

    public static void main(String[] args) {
        int i = new Solution().maxProfit(new int[]{2, 1, 2, 0, 1});
        System.out.println(i);
    }

    public int maxProfit(int[] prices) {
        int flag = 0;
        // 注意，这道题buy=0也是合法的，说明用0元购买了，所以要用-1标识没购买
        int buy = -1;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1] && (flag == 2 || flag == 0)) {
                flag = 1;
                buy = prices[i - 1];
            } else if (prices[i] < prices[i - 1] && (flag == 1 || flag == 0)) {
                if (flag == 1) {
                    int sold = prices[i - 1];
                    profit += sold - buy;
                    buy = -1;
                }
                flag = 2;
            }
        }
        int end = prices[prices.length - 1];
        if (buy >= 0 && buy < end) {
            profit += end - buy;
        }
        return profit;
    }
}
