package selfpracticeproblems.recursion.array;

import java.util.ArrayList;
import java.util.List;

public class LinearSearch {
    static void main(String[] args) {
//        int[] arr = {3, 9, 4, 6};
//        System.out.println(search(arr, 0, 6));
        int[] arr = {3, 9, 4, 6, 4};
        System.out.println(searchWithoutPassingListInParams(arr, 0, 4));
    }

    static int search(int[] arr, int index, int target) {
        if (index == arr.length) {
            return -1;
        }
        if (arr[index] == target) {
            return index;
        }
        return search(arr, index + 1, target);
    }

    static List<Integer> search(int[] arr, int index, int target, List<Integer> list) {
        if (index == arr.length) {
            return list;
        }
        if (arr[index] == target) {
            list.add(index);
        }
        return search(arr, index + 1, target, list);
    }

    static List<Integer> searchWithoutPassingListInParams(int[] arr, int index, int target) {
        if (index == arr.length) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        if (arr[index] == target) {
            list.add(index);
        }
        List<Integer> integers = searchWithoutPassingListInParams(arr, index + 1, target);

        list.addAll(integers);

        return list;

    }
}
