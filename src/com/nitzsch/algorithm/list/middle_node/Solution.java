package com.nitzsch.algorithm.list.middle_node;

import com.nitzsch.algorithm.list.ListNode;

/**
 * @author: nitzschhong
 * @create: 2022-03-12 10:03
 */
public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (null != slow && null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next;
            if (null == fast) {
                break;
            }
            fast = fast.next;
        }
        return slow;
    }
}
