package selfpracticeproblems.heap.mergeksorted;

import java.util.List;
import java.util.PriorityQueue;

public class SmallestRangeCoveringElementsFromKLists {
    class Element {
        int val;
        int listIndex;
        int elementIndex;
        public Element(int val, int listIndex, int elementIndex) {
            this.val = val;
            this.listIndex = listIndex;
            this.elementIndex = elementIndex;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Element> pq = new PriorityQueue<>((a,b) -> a.val - b.val);


        int currMax = Integer.MIN_VALUE;

        //traverse all the lists and put the first i.e the smallest  element present in the list into the heap
        // and update the current max
        for (int i = 0 ; i < nums.size() ; i++) {
            int num = nums.get(i).getFirst();
            pq.offer(new Element(num, i, 0));
            currMax = Math.max(currMax, num);
        }

        int rangeStart = 0;
        int rangeEnd = Integer.MAX_VALUE;

         while (pq.size() == nums.size()) {
             Element minElement =  pq.poll();
             int currMin = minElement.val;

             // Update best range
             if ( currMax - currMin < rangeEnd - rangeStart) {
                 rangeStart = currMin;
                 rangeEnd = currMax;
             }

             // Move to next element in same list
             if (minElement.elementIndex + 1 == nums.get(minElement.listIndex).size()) {
                 break;  // one list exhausted
             }

             int nextVal = nums.get(minElement.listIndex).get(minElement.elementIndex + 1);

             pq.offer(new Element(nextVal,minElement.listIndex, minElement.elementIndex + 1));

             currMax = Math.max(currMax,nextVal);
         }

         return new int[]{rangeStart,rangeEnd};


    }
}
