package selfpracticeproblems.linkedlist.basicopertions;

public class SearchInLinkedList {
    public boolean searchKey(Node head, int key) {
        // Code here
        //if(head.data == key) return true;
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) {
                return true;
            } else {
                temp = temp.next;
            }
        }
        return false;
    }
}
