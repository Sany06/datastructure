package com.example.demo.chatgpt.recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        candidateList(candidates, target, 0, new ArrayList<>(), list);
        return list;
    }

    public void candidateList(int[] candidates, int target, int start, List<Integer> tempList, List<List<Integer>> list) {

        if (target == 0) {
            list.add(new ArrayList<>(tempList));
            return;
        }


        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            if (candidates[i] > target) break;

            tempList.add(candidates[i]);
            //Observe we are incrementing the i here to i+1
            candidateList(candidates, target - candidates[i], i+1 , tempList, list);
            tempList.remove(tempList.size() - 1);
        }
    }
}
