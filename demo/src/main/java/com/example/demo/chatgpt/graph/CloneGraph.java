package com.example.demo.chatgpt.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CloneGraph {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }


        public Node cloneGraph(Node node) {
            if (node == null) return null;
            Map<Node, Node> map = new HashMap<>();
            return clone(node, map);
        }

        public Node clone(Node node, Map<Node, Node> map) {
            Node newnode = new Node(node.val);
            map.put(node, newnode);

            for (Node neighbour : node.neighbors) {
                if (!map.containsKey(neighbour)) {
                    newnode.neighbors.add(clone(neighbour, map));
                } else {
                    newnode.neighbors.add(map.get(neighbour));
                }
            }
            return newnode;
        }
    }
}
