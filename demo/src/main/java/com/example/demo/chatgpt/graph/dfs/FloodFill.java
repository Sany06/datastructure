package com.example.demo.chatgpt.graph.dfs;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    dfs(image,sr,sc,image[sr][sc],color);
    return image;
    }

    public  void dfs(int[][] image, int r, int c, int original ,int color) {
        if(r >= image.length || r < 0 || c >= image[0].length || c < 0 || image[r][c] == color || image[r][c] != original)  {
            return;
        }

        image[r][c] = color;

        dfs(image, r+1,c,original ,color);
        dfs(image, r-1,c, original,color);
        dfs(image, r,c+1, original,color);
        dfs(image, r,c-1, original,color);
    }
}
