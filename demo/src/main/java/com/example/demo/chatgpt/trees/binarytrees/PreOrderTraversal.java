package com.example.demo.chatgpt.trees.binarytrees;

import java.util.ArrayList;
import java.util.List;

public class PreOrderTraversal {
    List<Integer> list=new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return list;
    }

    private void preOrder(TreeNode root){
        if(root==null){
            return;
        }
        list.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}
