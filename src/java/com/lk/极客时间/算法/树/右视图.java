package com.lk.极客时间.算法.树;


import com.lk.极客时间.算法.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * Description: TODO
 *
 * @author likai
 * @date 2020-04-17 21:37
 */
public class 右视图 {
    public List<Integer> rightSideView(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                // 把每一层最后一个元素放进res
                if(i == size - 1){
                    res.add(node.val);
                }
            }
        }
        return res;
    }
}
