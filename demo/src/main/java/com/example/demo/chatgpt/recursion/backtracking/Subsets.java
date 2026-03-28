package com.example.demo.chatgpt.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    static void main(String[] args) {
        int[] arr = {1, 2, 3};
        //System.out.println(subsets(arr));
        List<List<Integer>> list=new ArrayList<>();
        calculateSubSet1(new ArrayList<>(),arr,0,list);
        System.out.println(list);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        return calculateSubSet(new ArrayList<>(), nums, 0);
    }

    static List<List<Integer>> calculateSubSet(List<Integer> processedList, int[] nums, int index) {
        if (index == nums.length) {
            List<List<Integer>> list = new ArrayList<>();
            list.add(new ArrayList<>(processedList));
            return list;
        }


        processedList.add(nums[index]);

        //include
        List<List<Integer>> left = calculateSubSet(processedList, nums, index + 1);

        //backtrack
        processedList.remove(processedList.size() - 1);

        //exclude
        List<List<Integer>> right = calculateSubSet(processedList, nums, index + 1);

        left.addAll(right);

        return left;
    }

    static void calculateSubSet1(List<Integer> processedList, int[] nums, int index,List<List<Integer>> list) {
        if (index == nums.length) {
            list.add(new ArrayList<>(processedList));
            return;
        }


        processedList.add(nums[index]);

        //include
        calculateSubSet1(processedList, nums, index + 1,list);

        //backtrack
        processedList.remove(processedList.size() - 1);

        //exclude
        calculateSubSet1(processedList, nums, index + 1,list);

    }
}
