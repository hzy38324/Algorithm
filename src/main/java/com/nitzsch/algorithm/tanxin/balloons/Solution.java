package com.nitzsch.algorithm.tanxin.balloons;

import java.util.Arrays;

/**
 * @author: nitzschhong
 * @create: 2022-10-04 08:40
 */
public class Solution {
    public static void main(String[] args) {
        // [[-2147483646,-2147483645],[2147483646,2147483647]]
        int[][] points = new int[2][2];
        points[0][0]=-2147483646;
        points[0][1]=-2147483645;
        points[1][0]=2147483646;
        points[1][1]=2147483647;
        int minArrowShots = new Solution().findMinArrowShots(points);
        System.out.println(minArrowShots);
    }
    public int findMinArrowShots(int[][] points) {
        // 使用Integer.compare排序，防止溢出
        Arrays.sort(points,(a, b)->{
            if(a[0]==b[0]){
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        int count = 0;
        // 有交集的最右位置
        int diffMax = 0;
        for(int i=0;i<points.length;i++) {
            // 如果没有交集（因为前面已经排序了，所以这里只要对比最左位置和之前的最右位置）
            if(i==0 || points[i][0]>diffMax){
                count++;
                diffMax=points[i][1];
                continue;
            }else {
                // 注意这里要取最小
                diffMax=Math.min(diffMax,points[i][1]);
            }
        }
        return count;
    }
}
