package com.nitzsch.algorithm.test;

import com.nitzsch.algorithm.array.ArrayStack;

/**
 * @author: nitzschhong
 * @create: 2022-02-04 11:45
 */
public class StackTest {
    public static void main(String[] args) {
        testStack_1();
    }

    private static void testStack_1() {
        ArrayStack arrayStack = new ArrayStack(4);
        assert arrayStack.count() == 0;
        assert arrayStack.capacity() == 4;

        arrayStack.push(0);
        assert arrayStack.count() == 1;
        assert arrayStack.capacity() == 4;

        arrayStack.push(1);
        assert arrayStack.count() == 2;
        int pop_1 = arrayStack.pop();
        assert pop_1 == 1;
        assert arrayStack.count() == 1;
        assert arrayStack.capacity() == 4;

        arrayStack.push(1);
        arrayStack.push(2);
        assert arrayStack.count() == 3;
        arrayStack.push(3);
        try {
            arrayStack.push(4);
        } catch (Exception e) {
            System.out.println("yes! exception");
        }
    }
}
