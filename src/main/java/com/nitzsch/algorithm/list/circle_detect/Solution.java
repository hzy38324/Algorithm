package com.nitzsch.algorithm.list.circle_detect;

import com.nitzsch.algorithm.list.ListNode;

/**
 * 链表环检测：快慢指针法
 * @author: nitzschhong
 * @create: 2022-02-20 11:59
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (null != slow && null != fast) {
            slow = slow.next;
            if (null == fast.next) {
                return false;
            }
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
