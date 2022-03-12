package com.nitzsch.algorithm.array;

/**
 * 动态数组
 *
 * @author: nitzschhong
 * @create: 2022-02-03 10:37
 */
public class DynamicArray {

    private int[] arr;

    private int count;

    public DynamicArray() {
        arr = new int[4];
    }

    public DynamicArray(int size) {
        arr = new int[size];
    }

    public int get(int index) {
        return arr[index];
    }

    public int count() {
        return this.count;
    }

    public int capacity() {
        return arr.length;
    }

    public void add(int value) {
        // 需要的容量
        int needCapacity = count() + 1;
        // 扩容
        if (needGrow(needCapacity)) {
            grow();
        }
        // 追加元素
        arr[count++] = value;
    }

    private boolean needGrow(int needCapacity) {
        int capacity = capacity();
        if (needCapacity > capacity) {
            return true;
        }
        return false;
    }

    private void grow() {
        // 执行扩容
        int capacity = capacity();
        int capacityAfterGrow = capacity * 2;
        int[] newArr = doGrow_v1(capacityAfterGrow);
        // 使用 JDK 编写的 native 函数
//        int[] newArr = Arrays.copyOf(arr, capacityAfterGrow);
        arr = newArr;
    }

    private int[] doGrow_v1(int capacityAfterGrow) {
        int[] newArr = new int[capacityAfterGrow];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    public void set(int index, int value) {
        if (index >= this.count) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
        arr[index] = value;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + count;
    }
}
