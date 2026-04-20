package selfpracticeproblems.linkedlist.basicopertions;

public class DeleteInASinglyLinkedList {
    //delete xth node
    Node deleteNode(Node head, int x) {
        if (x == 1) {
            head = head.next;
            return head;
        }
        int count = 1;

        Node temp = head;

        while(count != x - 1) {
            temp = temp.next;
            count++;
        }

        temp.next = temp.next.next;

        return head;


    }
}
