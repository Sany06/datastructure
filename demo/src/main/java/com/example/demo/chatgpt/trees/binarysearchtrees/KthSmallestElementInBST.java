package com.example.demo.chatgpt.trees.binarysearchtrees;

public class KthSmallestElementInBST {
    int k;
    int result;
    public int kthSmallest(TreeNode root, int k) {
        this.k=k;
        inorder(root);
        return result;
    }

    private void inorder(TreeNode root) {
        if (root==null){
            return;
        }

        inorder(root.left);
        k--;
        if (k==0){
            result=root.val;
            return;
        }

        inorder(root.right);
    }
}
