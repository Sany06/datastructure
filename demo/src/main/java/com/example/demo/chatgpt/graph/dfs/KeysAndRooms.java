package com.example.demo.chatgpt.graph.dfs;

import java.util.List;

public class KeysAndRooms {
    //TC : O(V + E)  SC: O(V)
    //V = number of rooms
    //E = total number of keys across all rooms
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];

        dfs(0, visited, rooms);

        for(boolean b : visited){
            if(!b) return false;
        }
        return true;
    }

    public void dfs(int room,boolean[] visited,List<List<Integer>> rooms ){
        if(visited[room]) return;

        visited[room] = true;

        for(int key : rooms.get(room)){
            dfs(key,visited,rooms);
        }
    }
}
