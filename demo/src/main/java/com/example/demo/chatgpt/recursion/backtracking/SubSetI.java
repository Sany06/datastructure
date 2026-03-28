package com.example.demo.chatgpt.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubSetI {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        calculate(new ArrayList<>(),nums,0,list);
        return list;
    }

    static void calculate(List<Integer> processed, int[] nums, int index, List<List<Integer>> list) {

        list.add(new ArrayList<>(processed));

        for (int i=index;i< nums.length;i++){

            processed.add(nums[i]);

            calculate(processed,nums,i+1,list);

            processed.remove(processed.size()-1);
        }
    }
}
