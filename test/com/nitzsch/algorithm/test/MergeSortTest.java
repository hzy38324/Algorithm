package com.nitzsch.algorithm.test;

import com.nitzsch.algorithm.sort.merge_sort.Solution;

import java.util.Arrays;

/**
 * @author: nitzschhong
 * @create: 2022-03-12 11:16
 */
public class MergeSortTest {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int a[] = {51, 46, 20, 18, 65, 97, 82, 30, 77, 50};
        solution.mergeSort(a);
        System.out.println("排序结果：" + Arrays.toString(a));
    }

}
