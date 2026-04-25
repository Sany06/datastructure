package selfpracticeproblems.linkedlist.sort;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode node) {
        if(node==null){
            return node;
        }
        ListNode dummy = node;
        while(dummy.next != null) {
            if(dummy.val == dummy.next.val) {
                dummy.next= dummy.next.next;
            } else {
                dummy = dummy.next;
            }
        }
        return node;
    }
}
