package selfpracticeproblems.linkedlist.basicopertions;

public class DeleteInASinglyLinkedList {
    //delete xth node
    Node deleteNode(Node head, int x) {
        Node dummy = new Node(-1);
        dummy.next=head;

        if (x == 1) {
            Node curr = head;
            head = curr.next;
            curr.next = null;
            dummy.next = head;
            return dummy.next;
        }

        Node curr = head;
        for (int i = 1 ; i < x -1 ; i++ ) {
            curr = curr.next;
        }
        Node t = curr.next;
        curr.next= curr.next.next;
        t.next= null;
        return dummy.next;
    }
}
