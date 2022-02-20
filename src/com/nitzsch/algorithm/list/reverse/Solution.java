package com.nitzsch.algorithm.list.reverse;

import com.nitzsch.algorithm.list.ListNode;

public class Solution {
    public ListNode ReverseList(ListNode head) {
//        return my_version(head);
        return beauty_version(head);
    }

    private ListNode my_version(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = cur;
        while (next != null) {
            cur = next;
            next = cur.next;
            cur.next = pre;
            pre = cur;
        }
        return cur;
    }

    private ListNode beauty_version(ListNode head) {
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
