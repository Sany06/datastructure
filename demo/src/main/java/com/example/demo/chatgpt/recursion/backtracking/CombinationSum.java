package com.example.demo.chatgpt.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        candidateList(candidates, target, 0, new ArrayList<>(), list);
        return list;
    }

    public void candidateList(int[] candidates, int target, int start, List<Integer> tempList, List<List<Integer>> list) {

        if (target == 0) {
            list.add(new ArrayList<>(tempList));
            return;
        }

        if (target < 0) return;

        for (int i = start; i < candidates.length; i++) {

            tempList.add(candidates[i]);
            candidateList(candidates, target - candidates[i], i, tempList, list);
            tempList.remove(tempList.size() - 1);
        }
    }
}
