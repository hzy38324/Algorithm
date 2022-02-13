package com.nitzsch.algorithm;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * 自己实现的栈
 * JDK 实现：
 * @see ArrayDeque 推荐
 * @see Stack JDK已经不推荐使用，见该类的注释，参考：https://stackoverflow.com/questions/12524826/why-should-i-use-deque-over-stack
 */
public class MyStack {

    private int[] arr;

    private int count;

    public MyStack() {
        this.arr = new int[8];
    }

    public MyStack(int oriSize) {
        this.arr = new int[oriSize];
    }

    public int count() {
        return this.count;
    }

    public int capacity() {
        return arr.length;
    }

    public void push(int value) {
        if (count >= capacity()) {
            throw new RuntimeException("stack full");
        }
        arr[count++] = value;
    }

    public int pop() {
        if (count <= 0) {
            throw new RuntimeException("stack empty");
        }
        int popIndex = --count;
        int popValue = arr[popIndex];
        clear(popIndex);
        return popValue;
    }

    private void clear(int popIndex) {
        arr[popIndex] = 0;
    }
}
