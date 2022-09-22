package com.nitzsch.algorithm.backward.restoreIpAddresses;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: nitzschhong
 * @create: 2022-09-22 09:04
 */
public class Solution {

    List<String> res = new ArrayList<>();
    List<String> ip = new ArrayList<>();
    private static int MAX_IP = 255;
    private static int MAX_IP_LENGTH = 3;

    public List<String> restoreIpAddresses(String s) {
        backward(s, 0);
        return res;
    }

    private void backward(String s, int startIndex) {
        // 获取横向遍历的终点：不能超过字符串长度，也不能超过ip地址每个整数的最大长度
        int tempEnd = startIndex + MAX_IP_LENGTH;
        int end = tempEnd > s.length() ? s.length() : tempEnd;
        for (int i = startIndex; i < end; i++) {
            // 递归终止条件：如果当前ip集合已经有4位，并且还没纵向遍历完，则终止
            if (ip.size() == 4) {
                return;
            }
            String sub = s.substring(startIndex, i + 1);
            // 递归终止条件：非法ip整数（以0开头，但又不是0）
            if (sub.charAt(0) == '0' && sub.length() != 1) {
                return;
            }
            int subIp = Integer.parseInt(sub);
            // 递归终止条件：非法ip整数（超过最大整数）
            if (subIp > MAX_IP) {
                return;
            }
            // 回溯模板：添加
            ip.add(sub);
            // 遍历到结尾了，并且是四位整数
            if (i + 1 == s.length() && ip.size() == 4) {
                StringBuffer sb = new StringBuffer(ip.get(0)).append(".").append(ip.get(1)).append(".").append(ip.get(2)).append(".").append(ip.get(3));
                res.add(sb.toString());
            } else {
                // 回溯模板：纵向遍历
                backward(s, i + 1);
            }
            // 回溯模板：撤销
            ip.remove(ip.size() - 1);
        }
    }

    public static void main(String[] args) {
        // expect ["255.255.11.135","255.255.111.35"]
        List<String> strings = new Solution().restoreIpAddresses("25525511135");
        // expect ["0.0.0.0"]
//        List<String> strings = new Solution().restoreIpAddresses("0000");
        System.out.println(strings);
    }
}
