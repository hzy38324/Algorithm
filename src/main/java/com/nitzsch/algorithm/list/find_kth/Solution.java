package com.nitzsch.algorithm.list.find_kth;

import com.nitzsch.algorithm.list.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: nitzschhong
 * @create: 2022-02-27 11:06
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param pHead ListNode类
     * @param k     int整型
     * @return ListNode类
     */
    public ListNode FindKthToTail(ListNode pHead, int k) {
        if (k <= 0) {
            return null;
        }
        ListNode slow = pHead;
        ListNode fast = pHead;
        int fastStep = 0;
        while (fastStep < k && null != fast) {
            fast = fast.next;
            fastStep++;
        }
        if (fastStep != k) {
            return null;
        }
        while (null != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 栈
     *
     * @param pHead
     * @param k
     * @return
     */
    private ListNode use_stack(ListNode pHead, int k) {
        // write code here
        if (pHead == null || k == 0) {
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        //链表节点压栈
        while (pHead != null) {
            stack.push(pHead);
            pHead = pHead.next;
        }
        // 判断栈的元素是否小于k
        if (stack.size() < k) {
            return null;
        }
        //在出栈串成新的链表
        ListNode firstNode = stack.pop();
        while (--k > 0) {
            // 将出栈的元素重新连接成为链表
            ListNode temp = stack.pop();
            firstNode = temp;
        }
        return firstNode;
    }

    /**
     * 两次遍历：没有快慢指针优雅
     *
     * @param pHead
     * @param k
     * @return
     */
    @Deprecated
    private ListNode double_loop(ListNode pHead, int k) {
        int size = 0;
        ListNode head = pHead;
        while (null != pHead) {
            pHead = pHead.next;
            size++;
        }
        int targetIndex = size - k;
        if (targetIndex < 0 || targetIndex > (size - 1)) {
            return null;
        }
        pHead = head;
        int curIndex = 0;
        while (null != pHead) {
            if (curIndex == targetIndex) {
                break;
            }
            pHead = pHead.next;
            curIndex++;
        }
        return pHead;
    }

    /**
     * 用数组：没有栈优雅
     *
     * @param pHead
     * @param k
     * @return
     */
    @Deprecated
    private ListNode use_arraylist(ListNode pHead, int k) {
        // write code here
        List<ListNode> arr = new ArrayList<>();
        while (null != pHead) {
            arr.add(pHead);
            pHead = pHead.next;
        }
        int size = arr.size();
        int index = size - k;
        if (index < 0 || index > (size - 1)) {
            return null;
        }
        return arr.get(index);
    }
}
