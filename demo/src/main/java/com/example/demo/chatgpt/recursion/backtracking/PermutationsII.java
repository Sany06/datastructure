package com.example.demo.chatgpt.recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
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
            //!used[i - 1] == the previous duplicate is NOT currently being used.
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            if (used[i]) continue;
            temp.add(nums[i]);
            used[i] = true;
            permutation(nums, used, temp, list);

            used[i] = false;
            temp.remove(temp.size() - 1);

        }
    }
}
