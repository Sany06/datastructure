package com.example.demo.chatgpt.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0 ; i < m ; i++) {
            for(int j = 0; j < n ; j++) {
                if(mat[i][j] == 0) {
                    q.offer(new int[]{i,j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        int[][] directions = {
                {1,0}, {-1,0},{0,1},{0,-1}
        };

        while(!q.isEmpty()) {
            int[] a = q.poll();
            int r = a[0];
            int c = a[1];

            for(int[] dir : directions) {
                int nr = dir[0] + r;
                int nc = dir[1] + c;

                if(nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] == -1) {
                    mat[nr][nc] = mat[r][c] + 1;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        return mat;
    }
}
