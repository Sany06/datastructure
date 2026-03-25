package selfpracticeproblems.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueenLeetCode {

    static List<List<String>> queens(int n) {
        boolean[][] board=new boolean[n][n];
        return helper(board,0);

    }

    private static List<List<String>> helper(boolean[][] board, int row){
        if (row == board.length) {
            List<List<String>> list = new ArrayList<>();
            list.add(printBoard(board));
            return list;
        }

        List<List<String>> list = new ArrayList<>();

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                list.addAll(helper(board, row + 1));
                board[row][col] = false;
            }
        }
        return list;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        //check straight up i.e vertical row
        for (int i = 0; i < row; i++) {
            if (board[i][col]){
                return false;
            }
        }
        //diagonal left
        int maxLeft=Math.min(row,col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row-i][col-i]){
                return false;
            }
        }
        
        //diagonal right
        int maxRight =Math.min(row,board.length-col-1);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row-i][col+i]){
                return false;
            }
        }


        return true;
    }

    private static List<String> printBoard(boolean[][] board) {
        List<String> result = new ArrayList<>();

        for (boolean[] row : board) {
            StringBuilder sb = new StringBuilder();
            for (boolean value : row) {
                if (value) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            result.add(sb.toString());
        }

        return result;
    }

}
