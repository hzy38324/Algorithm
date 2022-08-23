package com.nitzsch.algorithm.array.quan_pai_lie;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: nitzschhong
 * @create: 2022-08-18 21:51
 */
public class QuanPaiLie {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> permute = new QuanPaiLie().permute(nums);
        System.out.println(permute);
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> first = new ArrayList<Integer>();
        first.add(nums[0]);
        res.add(first);
        for(int i=1;i<nums.length;i++){
            List<List<Integer>> newRes = new ArrayList<List<Integer>>();
            for(int j=0;j<res.size();j++){
                List<Integer> subList = res.get(j);
                for(int k=0;k<=subList.size();k++){
                    List<Integer> newSubList = new ArrayList<Integer>();
                    for(int p=0,q=0;p<=subList.size();p++){
                        if(p==k){
                            newSubList.add(nums[i]);
                        }else{
                            newSubList.add(subList.get(q));
                            q++;
                        }
                    }
                    newRes.add(newSubList);
                }
            }
            res = newRes;
        }
        return res;
    }
}
