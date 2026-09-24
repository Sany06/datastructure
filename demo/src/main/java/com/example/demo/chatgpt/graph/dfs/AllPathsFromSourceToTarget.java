package com.example.demo.chatgpt.graph.dfs;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, path, result, 0);
        return result;
    }

    public void dfs(int[][] graph,List<Integer> path,  List<List<Integer>> result, int node) {

        if(node == graph.length - 1){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int next : graph[node]){
            path.add(next);
            dfs(graph,path,result,next);
            path.remove(path.size() - 1);
        }
    }
}
