package com.example.demo.chatgpt.graph.dfs;

import java.util.*;

public class DFS {
    public class AdjacencyListGraph {

        private Map<Integer, List<Integer>> adjacencyList;

        // Constructor
        public AdjacencyListGraph() {
            this.adjacencyList = new HashMap<>();
        }

        // Add a vertex to the graph
        public void addVertex(int vertex) {
            adjacencyList.put(vertex, new LinkedList<>());
        }

        // Remove a vertex from the graph
        private void removeVertex(int vertex) {
            adjacencyList.remove(vertex);
            // Remove edges pointing to the removed vertex
            for (List<Integer> neighbors : adjacencyList.values()) {
                neighbors.remove((Integer) vertex);
            }
        }

        // Add an edge between two vertices
        public void addEdge(int source, int destination) {
            adjacencyList.get(source).add(destination);
            adjacencyList.get(destination).add(source);
        }

        // Remove an edge between two vertices
        public void removeEdge(int source, int destination) {
            adjacencyList.get(source).remove((Integer) destination);
            adjacencyList.get(destination).remove((Integer) source);
        }

        // Display the adjacency list
        public void printGraph() {
            for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
                System.out.print(entry.getKey() + " -> ");
                for (Integer neighbor : entry.getValue()) {
                    System.out.print(neighbor + " ");
                }
                System.out.println();
            }
        }

        public void DFSIterative(int startVertex) {
            Stack<Integer> visited = new Stack<>();
            Set<Integer> set = new HashSet<>();

            visited.push(startVertex);

            while(!visited.isEmpty()) {

                int vertex = visited.pop();
                set.add(vertex);

                for(int neighbour: adjacencyList.getOrDefault(vertex,Collections.emptyList())){
                    if(!visited.contains(neighbour)){
                        visited.push(neighbour);
                    }
                }
            }
        }

        public void DFSRecursive(int startVertex) {
        Set<Integer> set = new HashSet<>();
        DFSRecursive(startVertex,set);
        }

        public void DFSRecursive(int startVertex, Set<Integer> set) {
            set.add(startVertex);

            for(int neighbour: adjacencyList.getOrDefault(startVertex,Collections.emptyList())){
                if(!set.contains(neighbour)){
                    DFSRecursive(neighbour,set);
                }
            }
        }
    }

}
