package com.example.demo.chatgpt.linkedlists;

import java.util.HashMap;
import java.util.Map;

public class LRUCache2 {
    class Node {
        int key;
        int value;
        Node prev,next;
        public Node(int key, int val) {
            this.key = key;
            this.value= val;
        }
    }

    Map<Integer,Node> map;
    int capacity;
    Node head, tail;

    public LRUCache2(int capacity) {
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;

    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);
        removeAndAddAtBegin(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            removeAndAddAtBegin(node);
        } else {
            Node node = new Node(key,value);
            map.put(key,node);
            addNodeAtBegin(node);

            if (map.size() > capacity) {
                Node lru = tail.prev;
                map.remove(lru.key);
                removeNode(lru);
            }
        }

    }

    public void removeAndAddAtBegin(Node node) {
        removeNode(node);
        addNodeAtBegin(node);
    }

    public void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addNodeAtBegin(Node node) {
        node.next= head.next;
        node.prev = head;

        head.next.prev= node;
        head.next = node;
    }
}
