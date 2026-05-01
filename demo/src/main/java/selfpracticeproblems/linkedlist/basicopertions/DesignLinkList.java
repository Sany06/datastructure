package selfpracticeproblems.linkedlist.basicopertions;

//Trick To remember If we have to add/delete a node at an index then we have to traverse to  the node before that index
// for that we have to do for(int i = 0;  i < index -1 ;i++) as this is 0 based indexing
public class DesignLinkList {
    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public Node head;
    public int size;

    public DesignLinkList() {
        head = null;
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        if (index == 0) return head.val;

        Node curr = head;

        for (int i = 0 ; i < index ;  i++) {
            curr = curr.next;
        }

        return curr.val;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        if (size == 0) {
            node.next = null;
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public void addAtTail(int val) {
        Node node = new Node(val);
        node.next = null;
        if (size == 0) {
            head = node;
        } else {

            Node curr = head;

            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = node;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;
        if (index == 0) {
            addAtHead(val);
            return;
        }

        if (index == size) {
            addAtTail(val);
            return;
        }

        Node curr = head;

        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }
        Node node = new Node(val);
        node.next = curr.next;
        curr.next = node;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;

        if (index == 0) {
            head = head.next;
            size--;
            return;
        }

        Node curr = head;
        for (int i =  0 ; i < index - 1 ; i++) {
            curr = curr.next;
        }

        Node t =  curr.next;
        curr.next = curr.next.next;
        t.next = null;

        size--;
    }
}
