package com.example.demo.chatgpt.trees;

public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums==null) return null;
        return sortedArrayToBST(nums,0,nums.length-1);
    }

    private TreeNode sortedArrayToBST(int[] nums,int left,int right){
        if (left > right) return null;
        int mid=(left+right)/2;

        TreeNode node = new TreeNode(nums[mid]);
        node.right=sortedArrayToBST(nums,mid+1,right);
        node.left=sortedArrayToBST(nums,left,mid-1);
        return node;

    }
}
