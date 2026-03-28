package com.example.demo.chatgpt.recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetII {
    static void main(String[] args) {
        int[] arr = {1, 2, 2};
        System.out.println(subsetsWithDup(arr));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        calculate(new ArrayList<>(),nums,0,list);
        return list;
    }

    static void calculate(List<Integer> processed, int[] nums, int index, List<List<Integer>> list) {

        list.add(new ArrayList<>(processed));

        for (int i=index;i< nums.length;i++){
            if (i>index && nums[i]==nums[i-1]) continue;

            processed.add(nums[i]);

            calculate(processed,nums,i+1,list);

            processed.remove(processed.size()-1);
        }
    }
}
