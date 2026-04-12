package selfpracticeproblems.arrays.slidingwindow.fixedwindowsize;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] arr = new int[nums.length -k +1];
        Deque<Integer> dq = new LinkedList();

        for (int i = 0; i< nums.length ; i++) {

            if(!dq.isEmpty() && dq.peekFirst() == i-k ) {
                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);

            if (i >= k-1) {
                arr[i -k + 1] = nums[dq.peekFirst()];
            }
        }
        return arr;
    }

}
