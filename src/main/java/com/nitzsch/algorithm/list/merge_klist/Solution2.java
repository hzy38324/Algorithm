package com.nitzsch.algorithm.list.merge_klist;

import com.nitzsch.algorithm.list.ListNode;

import java.util.ArrayList;

/**
 * @author: nitzschhong
 * @create: 2022-02-20 12:55
 */
public class Solution2 {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // 采用分治进行合并链表
        return mergeList(lists, 0, lists.size() - 1);
    }

    // 分治进行链表两两合并
    public ListNode mergeList(ArrayList<ListNode> lists, int L, int R) {

        if (L == R) {
            return lists.get(L);
        }
        if (L > R) {
            return null;
        }

        int mid = L + ((R - L) >> 1);
        return merge(mergeList(lists, L, mid), mergeList(lists, mid + 1, R));
    }

    // 合并两个链表，对比合并
    public ListNode merge(ListNode l1, ListNode l2) {

        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = (l1 == null ? l2 : l1);
        return dummy.next;
    }
}
