package selfpracticeproblems.linkedlist.basicopertions;

public class LinkedListEndInsertion {
    public Node insertAtEnd(Node head, int x) {
        Node n = new Node(x);
        n.next = null;

        if(head ==  null) return n;

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = n;

        return head;
    }
}
