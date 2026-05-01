package selfpracticeproblems.heap.mergeksorted;

import java.util.*;

public class FindKPairsWithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]])
        );

        Set<String> visited = new HashSet<>();

        pq.offer(new int[]{0, 0});
        visited.add("0,0");

        while (k-- > 0 && !pq.isEmpty()) {
            int[] curr = pq.poll();
            int i = curr[0];
            int j = curr[1];

            result.add(Arrays.asList(nums1[i], nums2[j]));

            if (i + 1 < nums1.length && visited.add((i + 1) + "," + j)) {
                pq.offer(new int[]{i + 1, j});
            }

            if (j + 1 < nums2.length && visited.add(i + "," + (j + 1))) {
                pq.offer(new int[]{i, j + 1});
            }
        }

        return result;
    }
}
