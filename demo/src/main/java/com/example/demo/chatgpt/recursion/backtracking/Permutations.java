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

    public void permutation(int[] nums, boolean[] used, List<Integer> processed, List<List<Integer>> list) {

        if (processed.size() == nums.length) {
            list.add(new ArrayList<>(processed));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            processed.add(nums[i]);
            used[i] = true;
            permutation(nums, used, processed, list);

            used[i] = false;
            processed.remove(processed.size() - 1);

        }
    }
}
