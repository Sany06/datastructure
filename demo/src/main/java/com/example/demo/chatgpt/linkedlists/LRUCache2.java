package com.example.demo.chatgpt.linkedlists;

import java.util.HashMap;

public class LRUCache2 {
    public class Node {
        int key;
        int val;
        Node next;
        Node prev;
        public Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }
    private final int size;
    private HashMap<Integer,Node> map;
    private Node head;
    private Node tail;
    public LRUCache2(int capacity) {
    this.size=capacity;
    this.map=new HashMap<>();
    this.head=new Node(0,0);
    this.tail=new Node(0,0);
    head.next=tail;
    tail.prev=head;
    }

    public int get(int key) {
        if (map.containsKey(key)){
            Node node=map.get(key);
            removeNode(node);
            addFirst(node);
            return node.val;
        } else return -1;
    }

    private void removeNode(Node node) {
        map.remove(node.key);
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    private void addFirst(Node node) {
        map.put(node.key,node);
        node.next=head.next;
        node.prev=head;
        head.next.prev=node;
        head.next=node;

    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            removeNode(node);
            map.put(key,node);
            addFirst(node);
        } else {
            if (size== map.size()) {
                removeNode(tail.prev);
            }
            addFirst(new Node(key, value));
        }
    }
}
