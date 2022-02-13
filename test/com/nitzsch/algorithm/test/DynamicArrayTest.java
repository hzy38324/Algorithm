package com.nitzsch.algorithm.test;

import com.nitzsch.algorithm.DynamicArray;

import java.util.ArrayList;

/**
 * @author: nitzschhong
 * @create: 2022-02-04 11:45
 */
public class DynamicArrayTest {
    public static void main(String[] args) {
        testDynamicArray_1();
        testArrayList_1();
    }

    private static void testArrayList_1() {
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
    }

    private static void testDynamicArray_1() {
        DynamicArray dynamicArray = new DynamicArray(4);
        assert dynamicArray.count() == 0;
        assert dynamicArray.capacity() == 4;
        dynamicArray.add(0);
        assert dynamicArray.count() == 1;
        assert dynamicArray.capacity() == 4;
        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);
        dynamicArray.add(4);
        assert dynamicArray.count() == 5;
        assert dynamicArray.capacity() == 8;
    }
}
