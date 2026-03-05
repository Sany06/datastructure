package com.example.demo.chatgpt.trees;

public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pVal=p.val;
        int qVal=q.val;
        TreeNode temp=root;
        while(temp!=null){
            if(pVal > temp.val && qVal > temp.val){
                temp=temp.right;
            }
            else if(pVal < temp.val && qVal < temp.val){
                temp=temp.left;
            } else {
                return temp;
            }
        }
        return temp;
    }
}
