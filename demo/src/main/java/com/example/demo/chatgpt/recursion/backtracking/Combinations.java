package com.example.demo.chatgpt.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        combination(1, n, k, new ArrayList<>(), list);
        return list;
    }

    public void combination(int start, int n, int k, List<Integer> tempList, List<List<Integer>> list) {
        if (tempList.size() == k) {
            List<Integer> list1 = new ArrayList<>(tempList);
            list.add(list1);
            return;
        }

        for (int i = start; i <= n; i++) {
            tempList.add(i);
            combination(i + 1, n, k, tempList, list);
            tempList.remove(tempList.size() - 1);
        }
    }
}
