package com.nitzsch.algorithm.list.merge_klist;

import com.nitzsch.algorithm.list.ListNode;

import java.util.ArrayList;

/**
 * @author: nitzschhong
 * @create: 2022-02-20 12:55
 */
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // 采用分治进行合并链表
        return mergeList(lists, 0, lists.size() - 1);
//        return my_version(lists);
    }

    /**
     * 递归+分治
     * @param lists
     * @param L
     * @param R
     * @return
     */
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

    /**
     * 多次遍历，时间复杂度高
     * @param lists
     * @return
     */
    private ListNode my_version(ArrayList<ListNode> lists) {
        if (null == lists || lists.size() <= 0) {
            return null;
        }
        ListNode last = null;
        int i = 1;
        ArrayList<ListNode> mergeList = lists;
        while (mergeList.size() != 1) {
            ArrayList<ListNode> newMergeList = new ArrayList<>();
            for (ListNode listNode : mergeList) {
                if (i == 1) {
                    last = listNode;
                } else if (i == 2) {
                    // merge
                    ListNode merge = merge(last, listNode);
                    newMergeList.add(merge);
                    // reset
                    i = 1;
                    continue;
                }
                i++;
            }
            // merge 多出来的一条链表
            if (i == 2) {
                int lastIndex = newMergeList.size() - 1;
                ListNode mergeAgain = merge(newMergeList.get(lastIndex), last);
                // 替换掉
                newMergeList.remove(lastIndex);
                newMergeList.add(mergeAgain);
            }
            mergeList = newMergeList;
        }
        return mergeList.get(0);
    }

    private ListNode merge(ListNode list1, ListNode list2) {
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
}
