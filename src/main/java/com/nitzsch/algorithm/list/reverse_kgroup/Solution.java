package com.nitzsch.algorithm.list.reverse_kgroup;

import com.nitzsch.algorithm.list.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: nitzschhong
 * @create: 2022-05-10 22:52
 */
public class Solution {
    /**
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        return my_version(head, k);
    }

    private ListNode my_version(ListNode head, int k) {
        if (k == 1 || null == head) {
            return head;
        }
        List<ListNode> listNodes = new ArrayList<>();
        int i = 1;
        ListNode next = head;
        ListNode cur = head;
        ListNode begin = head;
        // 先切割成多个链表，分别反转
        while (null != cur) {
            if (i == k) {
                next = cur.next;
                cur.next = null;
                ListNode newBegin = reverse(begin);
                listNodes.add(newBegin);
                cur = next;
                begin = next;
                i = 1;
            } else {
                cur = cur.next;
                i++;
            }
        }
        if (i != 1) {
            listNodes.add(begin);
        }
        // 合并多个反转后的链表
        ListNode tail = null;
        for (ListNode node : listNodes) {
            if (null != tail) {
                tail.next = node;
            }
            while (node != null) {
                tail = node;
                node = node.next;
            }
        }
        return listNodes.get(0);
    }

    private ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while (null != cur) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
