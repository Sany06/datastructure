package com.example.demo.chatgpt.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        permutation(nums, used, new ArrayList<>(), list);
        return list;
    }

    public void permutation(int[] nums, boolean[] used, List<Integer> temp, List<List<Integer>> list) {

        if (temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            temp.add(nums[i]);
            used[i] = true;
            permutation(nums, used, temp, list);

            used[i] = false;
            temp.remove(temp.size() - 1);

        }
    }
}
