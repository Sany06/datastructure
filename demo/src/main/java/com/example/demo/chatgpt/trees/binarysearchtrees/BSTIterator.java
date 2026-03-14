package com.example.demo.chatgpt.trees.binarysearchtrees;

import java.util.ArrayList;
import java.util.List;

public class BSTIterator {
    List<Integer> list;
    int index=-1;

    public BSTIterator(TreeNode root) {
        list=new ArrayList<>();
        inOrder(root,list);
    }

    public void inOrder(TreeNode root,List<Integer> list){
        if(root==null){return;}

        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }

    public int next() {
        index++;
        return list.get(index);
    }

    public boolean hasNext() {
        return index < list.size()-1;
    }
}
