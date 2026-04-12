package selfpracticeproblems.arrays.slidingwindow.fixedwindowsize;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstNegativeInEveryWindowOfSizeK {
    static List<Integer> firstNegInt(int[] arr, int k) {
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        int n = arr.length;

        while (j < n) {
            if (arr[j] < 0) {
                q.offer(arr[j]);
            }
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                if (q.isEmpty()) {
                    list.add(0);
                } else {
                    list.add(q.peek());
                }
                if (!q.isEmpty() && q.peek() == arr[i]) {
                    q.poll();
                }
                i++;
                j++;
            }
        }
        return list;
    }
}
