package com.example.demo.chatgpt.trees.binarytrees;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root==null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);


        while (!queue.isEmpty()){


            List<Integer> list = new ArrayList<>();
            int n=queue.size();

            for (int i=0;i < n;i++){
                TreeNode node = queue.poll();

                list.add(node.val);

                if (node.left!=null){
                    queue.add(node.left);
                }

                if (node.right!=null){
                    queue.add(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}
