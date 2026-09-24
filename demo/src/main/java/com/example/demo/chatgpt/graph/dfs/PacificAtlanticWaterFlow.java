package com.example.demo.chatgpt.graph.dfs;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for(int i = 0; i< m ; i++) {
            dfs(i, 0, pacific, -1,-1, heights);
            dfs(i, n-1, atlantic, -1,-1,heights);
        }

        for(int j = 0; j < n ; j++) {
            dfs(0, j, pacific, -1,-1,heights);
            dfs(m-1, j, atlantic, -1,-1,heights);
        }

        for(int i = 0; i < m ; i++) {
            for(int j = 0; j < n; j++) {
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }
        return res;
    }

    public void dfs(int r, int c, boolean[][] visited, int or, int oc, int[][] heights) {
        if(r < 0 || c < 0 || r >= heights.length || c >= heights[0].length ||
                visited[r][c] ) return;

        //since we are starting from the water and moving backwards so we are checking
        // if old height > curr height so if that is the case water cant flow to the ocean
        // so we are doing return
        if (or >= 0 && oc >= 0 &&
                heights[or][oc] > heights[r][c]) {
            return;
        }

        visited[r][c] = true;

        dfs(r + 1,c,visited,r,c,heights);
        dfs(r - 1,c,visited,r,c,heights);
        dfs(r,c + 1,visited,r,c,heights);
        dfs(r,c -1,visited,r,c,heights);
    }
}
