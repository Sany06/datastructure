package selfpracticeproblems.heap.mergeksorted;



import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        PriorityQueue<ListNode> pq = new PriorityQueue<>( (a,b)  -> Integer.compare(a.val,b.val));

        for (ListNode listNode : lists) {
            if (listNode != null) {
                pq.offer(listNode);
            }
        }

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            tail.next = node;
            tail = tail.next;

            if (node.next != null) {
                pq.offer(node.next);
            }
        }
        return dummy.next;
    }
}
