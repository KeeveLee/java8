package com.lk.极客时间.算法.树;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * @author likai
 */
public class 验证二叉搜索树 {

    List<Integer> list = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        inorder(root);
        if (list.size()<=1){
            return true;
        }
        for (int i = 0; i < list.size() -1; i++) {
            if (list.get(i)>=list.get(i+1)){
                return false;
            }
        }

        return true;
    }

    /**
     * 中序遍历
     */
    private void inorder(TreeNode root){
        if (root == null){
            return;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }



    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
}
