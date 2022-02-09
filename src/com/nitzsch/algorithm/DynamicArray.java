package com.nitzsch.algorithm;

/**
 * 动态数组
 *
 * @author: nitzschhong
 * @create: 2022-02-03 10:37
 */
public class DynamicArray {

    private int[] arr;

    private int size;

    public DynamicArray() {
        arr = new int[4];
    }

    public DynamicArray(int size) {
        arr = new int[size];
    }

    public int get(int index) {
        return arr[index];
    }

    public int size() {
        return this.size;
    }

    public int capacity() {
        return arr.length;
    }

    public void set(int index, int value) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
        arr[index] = value;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    public void add(int value) {
        // todo 对比 ArrayList 的扩容方法
        // 判断是否需要扩容，如果元素数量已经等于最大容量，则执行扩容（也可以优化成到达一定百分比时扩容）
        int capacityNow = capacity();
        if (size() == capacityNow) {
            // 执行扩容
            int[] newArr = new int[capacityNow * 2];
            for (int i = 0; i < capacityNow; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
        // 扩容完毕/无需扩容，则追加元素
        arr[size++] = value;
    }
}
