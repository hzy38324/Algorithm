package com.nitzsch.algorithm.sort.merge_sort;

/**
 * @author: nitzschhong
 * @create: 2022-03-12 11:03
 */
public class Solution {

    public void mergeSort(int[] arr) {
        mergeSortR(arr, 0, arr.length - 1);
    }

    public void mergeSortR(int[] arr, int begin, int end) {
        if (begin == end) {
            return;
        }
        int mid = (begin + end) / 2;
        // 分治递归
        mergeSortR(arr, begin, mid);
        mergeSortR(arr, mid + 1, end);
        // 将A[p...q]和A[q+1...r]合并为A[p...r]
        merge(arr, begin, mid, end);
    }

    public void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            a[k2 + low] = temp[k2];
        }
    }
}
