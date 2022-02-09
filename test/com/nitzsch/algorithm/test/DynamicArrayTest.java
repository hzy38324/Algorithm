package com.nitzsch.algorithm.test;

import com.nitzsch.algorithm.DynamicArray;
import sun.jvm.hotspot.utilities.Assert;

/**
 * @author: nitzschhong
 * @create: 2022-02-04 11:45
 */
public class DynamicArrayTest {
    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray(4);
        assert dynamicArray.size() == 0;
        assert dynamicArray.capacity() == 4;
        dynamicArray.add(0);
        assert dynamicArray.size() == 1;
        assert dynamicArray.capacity() == 4;
        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);
        dynamicArray.add(4);
        assert dynamicArray.size() == 5;
        assert dynamicArray.capacity() == 8;
    }
}
