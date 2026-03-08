package com.example.demo.chatgpt.trees.binarysearchtrees;

import java.util.ArrayList;

public class TwoSumIV {
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> list1 = new ArrayList<>();
        inOrderTraversal(root, list1);
        int start = 0;
        int end = list1.size() - 1;
        while (start < end) {
            int sum = list1.get(start) + list1.get(end);
            if (sum == k) {
                return true;
            }
            if (sum < k) {
                start++;
            } else {
                end--;
            }
        }
        return false;
    }

    private void inOrderTraversal(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left, list);
        list.add(root.val);
        inOrderTraversal(root.right, list);
    }
}
