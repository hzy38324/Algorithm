package com.nitzsch.algorithm.test;

import com.nitzsch.algorithm.MyStack;

/**
 * @author: nitzschhong
 * @create: 2022-02-04 11:45
 */
public class StackTest {
    public static void main(String[] args) {
        testStack_1();
    }

    private static void testStack_1() {
        MyStack myStack = new MyStack(4);
        assert myStack.count() == 0;
        assert myStack.capacity() == 4;

        myStack.push(0);
        assert myStack.count() == 1;
        assert myStack.capacity() == 4;

        myStack.push(1);
        assert myStack.count() == 2;
        int pop_1 = myStack.pop();
        assert pop_1 == 1;
        assert myStack.count() == 1;
        assert myStack.capacity() == 4;

        myStack.push(1);
        myStack.push(2);
        assert myStack.count() == 3;
        myStack.push(3);
        try {
            myStack.push(4);
        } catch (Exception e) {
            System.out.println("yes! exception");
        }
    }
}
