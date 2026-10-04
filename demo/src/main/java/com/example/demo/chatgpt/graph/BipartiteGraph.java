package com.example.demo.chatgpt.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];

        for(int i = 0; i< graph.length; i++) {
            if(color[i] == 0){
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                color[i] = 1;
                while(!q.isEmpty()) {
                    int node = q.poll();
                    for(int n : graph[node]){
                        if(color[n] == color[node]) return false;
                        else if(color[n] == 0) {
                            q.offer(n);
                            color[n] = -color[node];
                        }

                    }
                }
            }
        }
        return true;
    }
}
