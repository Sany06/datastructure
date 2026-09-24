package com.example.demo.chatgpt.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;
        int n = grid.length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,1});

        grid[0][0] = 1;

        int[][] directions = {
                {-1,-1}, {-1,0}, {-1,1} ,{0,1},{1,1},{1,0},{1,-1},{0,-1}
        };

        while(!q.isEmpty()) {
            int[] pop = q.poll();
            int r = pop[0];
            int c = pop[1];
            int dist = pop[2];

            if( r == n -1 && c == n-1){
                return dist;
            }

            for(int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 0) {
                    grid[nr][nc] = 1;
                    q.offer(new int[]{nr,nc, dist + 1});
                }

            }
        }
        return -1;
    }
}
