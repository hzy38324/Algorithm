package com.nitzsch.algorithm.list.merge;

import com.nitzsch.algorithm.list.ListNode;

/**
 * @author: nitzschhong
 * @create: 2022-02-20 12:55
 */
public class Solution {
    public ListNode Merge(ListNode list1, ListNode list2) {
        return beauty_version(list1, list2);
    }

    private ListNode beauty_version(ListNode list1, ListNode list2) {
        ListNode vhead = new ListNode(-1);
        ListNode cur = vhead;
        while (null != list1 && null != list2) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = null == list1 ? list2 : list1;
        return vhead.next;
    }

    private ListNode my_version(ListNode list1, ListNode list2) {
        if (null == list1 && null == list2) {
            return null;
        }
        if (null == list1 && null != list2) {
            return list2;
        }
        if (null != list1 && null == list2) {
            return list1;
        }
        ListNode resultHead = list1.val > list2.val ? list2 : list1;
        // 找到list2里第一个不小于list1的节点
        while (null != list1 && null != list2 && list2.val < list1.val) {
            if (null != list2.next && list2.next.val >= list1.val) {
                ListNode temp = list2.next;
                list2.next = list1;
                list2 = temp;
                break;
            }
            list2 = list2.next;
        }
        while (null != list1 && null != list2) {
            if (null == list1.next) {
                list1.next = list2;
                break;
            }
            if (list2.val >= list1.next.val) {
                list1 = list1.next;
            } else {
                ListNode temp1 = list1.next;
                ListNode temp2 = list2.next;
                list1.next = list2;
                list2.next = temp1;
                list1 = list2;
                list2 = temp2;
            }
        }
        return resultHead;
    }
}
