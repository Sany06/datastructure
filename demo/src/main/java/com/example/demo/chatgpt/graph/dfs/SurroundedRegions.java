package com.example.demo.chatgpt.graph.dfs;

public class SurroundedRegions {
    //TC : O(m x n)
    //TC : O(m x n)
    //Soln approach : First we will start from all the 4 side walls and mark the cells which will be safe / whose 0 wont be changed by
    // converting them to #
    // After that we will again traverse through the matrix and change 0 to x, if we get # then it will be converted to 0
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i< m ; i++) {
            dfs(board, i, 0);
            dfs(board, i, n-1);
        }

        for(int j = 0; j< n ; j++) {
            dfs(board, 0, j);
            dfs(board, m - 1, j);
        }

        for(int i = 0; i< m; i++) {
            for(int j = 0; j< n ; j++) {
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                } else if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    //Through this we are marking the 0 which are connected to the border cells i.e the cells which are safe
    //we are marking the cells as #
    public void dfs(char[][] board, int r , int c) {
        int m = board.length, n = board[0].length;
        if(r < 0 || c < 0 ||  r >= m  || c >= n || board[r][c] != 'O' ) return;

        board[r][c] = '#';

        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r , c + 1);
        dfs(board, r , c - 1);
    }
}
