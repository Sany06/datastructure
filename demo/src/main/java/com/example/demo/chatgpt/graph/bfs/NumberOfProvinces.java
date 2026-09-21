package com.example.demo.chatgpt.graph.bfs;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int number = 0;
        int n = isConnected.length;
        boolean[] visited = new boolean[n];

        for(int i = 0; i< n ; i++) {
            if(!visited[i]) {
                number++;
                dfs(i, isConnected, visited);
            }
        }
        return number;
    }

    public void dfs(int i , int[][] isConnected, boolean[] visited) {

        visited[i] = true;

        for(int j = 0; j < isConnected[0].length; j++){
            if(isConnected[i][j] == 1 && !visited[j]){
                dfs(j, isConnected, visited);
            }
        }
    }
}
