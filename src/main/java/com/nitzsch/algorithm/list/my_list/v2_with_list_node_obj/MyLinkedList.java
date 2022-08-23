package com.nitzsch.algorithm.list.my_list.v2_with_list_node_obj;

import com.nitzsch.algorithm.list.ListNode;

/**
 * @author: nitzschhong
 * @create: 2022-08-21 12:20
 */
public class MyLinkedList {

    private ListNode head;

    private int size;

    public MyLinkedList() {

    }

    public int get(int index) {
        ListNode cur = head;
        int i = 0;
        while(cur!=null){
            if(i==index) return cur.val;
            cur = cur.next;
            i++;
        }
        return -1;
    }

    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addAtTail(int val) {
        if(size==0){
            addAtHead(val);
            return;
        }
        ListNode cur = new ListNode(-1);
        cur.next = head;
        while(cur.next!=null){
            cur = cur.next;
        }
        ListNode newNode = new ListNode(val);
        cur.next = newNode;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if(index <= 0){
            addAtHead(val);
            // 这里第一次漏了
            return;
        }
        if(index == this.size){
            addAtTail(val);
            // 这里第一次漏了
            return;
        }
        ListNode cur = new ListNode(-1);
        cur.next = head;
        int i = 0;
        while(cur.next!=null){
            if(i==index){
                ListNode newNode = new ListNode(val);
                // 这里第一次写错了
                ListNode temp = cur.next;
                cur.next = newNode;
                newNode.next = temp;
                size++;
                break;
            }
            // 这里第一次漏了
            cur = cur.next;
            i++;
        }
    }

    public void deleteAtIndex(int index) {
        ListNode cur = new ListNode(-1);
        cur.next = head;
        int i = 0;
        while(cur.next!=null){
            if(i==index){
                cur.next = cur.next.next;
                // 漏了，要考虑删除头部
                if(i==0){
                    head = cur.next;
                }
                size--;
                break;
            }
            // 这里第一次漏了
            cur = cur.next;
            i++;
        }
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        /**
         * ["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
         * [[],[7],[2],[1],[3,0],[2],[6],[4],[4],[4],[5,0],[6]]
         */
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(7);
        linkedList.addAtHead(2);
        linkedList.addAtHead(1);
        linkedList.addAtIndex(3,0);
        linkedList.deleteAtIndex(2);
        linkedList.addAtHead(6);

        linkedList.addAtTail(4);
        System.out.println(linkedList.get(4));
        linkedList.addAtHead(4);
        linkedList.addAtIndex(5,0);
        linkedList.addAtHead(6);
    }

    private static void test2() {
        /**
         * ["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
         * [[],[1],[3],[1,2],[1],[0],[0]]
         */
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);
        System.out.println(linkedList.get(1));
        linkedList.deleteAtIndex(0);
        System.out.println(linkedList.get(0));
    }

    private static void test3() {
        /**
         ["MyLinkedList","addAtIndex","addAtIndex","addAtIndex","get"]
         [[],[0,10],[0,20],[1,30],[0]]
         */
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtIndex(0,10);
        linkedList.addAtIndex(0,20);
        linkedList.addAtIndex(1,30);
        System.out.println(linkedList.get(0));
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */