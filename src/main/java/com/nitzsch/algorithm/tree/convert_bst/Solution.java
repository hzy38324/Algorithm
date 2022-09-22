package com.nitzsch.algorithm.tree.convert_bst;

import com.nitzsch.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: nitzschhong
 * @create: 2022-09-17 08:36
 */
public class Solution {
    int index = 0;
    public TreeNode convertBST(TreeNode root) {
        // 获取递增数组
        List<Integer> arrray = new ArrayList();
        traversal(root, arrray);
        if(arrray.size()<2){
            return root;
        }
        // 数组求和
        for(int i=arrray.size()-2;i>=0;i--){
            arrray.set(i, arrray.get(i) + arrray.get(i+1));
        }
        traversalAndModify(root, arrray);
        return root;
    }

    private void traversal(TreeNode root, List<Integer> arrray){
        if(root==null){
            return;
        }
        traversal(root.left,arrray);
        arrray.add(root.val);
        traversal(root.right,arrray);
    }

    private void traversalAndModify(TreeNode root, List<Integer> arrray){
        if(root==null){
            return;
        }
        traversalAndModify(root.left,arrray);
        root.val = arrray.get(index++);
        traversalAndModify(root.right,arrray);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(4, new TreeNode(1), new TreeNode(6));
        new Solution().convertBST(a);
        System.out.println(a);
    }
}
