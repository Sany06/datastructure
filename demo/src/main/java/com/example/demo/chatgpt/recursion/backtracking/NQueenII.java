package com.example.demo.chatgpt.recursion.backtracking;

public class NQueenII {
    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        return helper(board, 0);
    }

    public int helper(boolean[][] board, int row){
        if(row == board.length){
            return 1;
        }

        int count = 0;

        for(int col = 0 ; col < board.length ; col++) {
            if(ispossible(board, row, col)) {
                board[row][col] = true;
                count += helper(board, row + 1);
                board[row][col] = false;
            }
        }

        return count;
    }

    boolean ispossible(boolean[][] board, int row, int col) {
        //checkupwards
        for(int i = 0; i< row; i++){
            if(board[i][col]) {
                return false;
            }
        }

        int minleft = Math.min(row,col);

        for(int i = 1; i<=minleft; i++) {
            if(board[row - i][ col - i])
                return false;
        }

        int rightmax = Math.min(row, board.length - col - 1);
        for(int i = 1; i <= rightmax; i++) {
            if(board[row - i][col + i]) return false;
        }
        return true;
    }
}
