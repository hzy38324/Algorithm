package com.nitzsch.algorithm.test;

import com.nitzsch.algorithm.list.ListNode;
import com.nitzsch.algorithm.list.reverse_between.Solution;

/**
 * @author: nitzschhong
 * @create: 2022-05-09 23:35
 */
public class ReverseBetweenTest {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next  = new ListNode(2);
        head.next.next  = new ListNode(3);
        head.next.next.next  = new ListNode(4);
        head.next.next.next.next  = new ListNode(5);
        ListNode listNode = new Solution().reverseBetween(head, 2, 4);
        System.out.println(listNode);
    }
}
