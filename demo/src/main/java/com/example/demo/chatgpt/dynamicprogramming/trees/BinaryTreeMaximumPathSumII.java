package com.example.demo.chatgpt.dynamicprogramming.trees;
// this problem is from  leaf to leaf only
public class BinaryTreeMaximumPathSumII {
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        solve(root);
        return res;
    }

    int solve(TreeNode root) {
        if (root == null) return 0;

        int l = solve(root.left);
        int r = solve(root.right);

        l = Math.max(0, l);
        r = Math.max(0, r);

        if (root.left != null && root.right!= null) {

            int temp = root.val + Math.max(l, r);

            int ans = root.val + l + r;

            res = Math.max(res, ans);

            return temp;
        }
        return root.left == null ? root.val + r : root.val + l;

    }
}
