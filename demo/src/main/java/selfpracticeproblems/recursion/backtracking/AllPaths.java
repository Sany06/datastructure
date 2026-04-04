package selfpracticeproblems.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class AllPaths {
    static void main(String[] args) {
        boolean[][] board = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        printAllPaths("", 0, 0, board);
        System.out.println(printAllPathsInList("", 0, 0, board));
    }

    //here we will be traversing left,right,up,down i.e all possible paths
    static void printAllPaths(String p, int row, int col, boolean[][] board) {
        if (row == board.length - 1 && col == board[0].length - 1) {
            System.out.println(p);
            return;
        }
        if (!board[row][col]) {
            return;
        }

        //marking the cell as traversed so that it is not traversed again
        board[row][col] = false;

        //going up
        if (row > 0) {
            printAllPaths(p + "U", row - 1, col, board);
        }
        //going down
        if (row < board.length - 1) {
            printAllPaths(p + "D", row + 1, col, board);
        }
        //going right
        if (col < board[0].length - 1) {
            printAllPaths(p + "R", row, col + 1, board);
        }
        //going left
        if (col > 0) {
            printAllPaths(p + "L", row, col - 1, board);
        }

        // this line is where the function will be over
        // so before the function gets removed, also remove the changes that were made by that function
        board[row][col] = true;

    }

    static List<String> printAllPathsInList(String p, int row, int col, boolean[][] board) {
        if (row == board.length - 1 && col == board[0].length - 1) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        if (!board[row][col]) {
            return new ArrayList<>();
        }

        List<String> list = new ArrayList<>();

        //marking the cell as traversed so that it is not traversed again
        board[row][col] = false;

        //going up
        if (row > 0) {
            list.addAll(printAllPathsInList(p + "U", row - 1, col, board));
        }
        //going down
        if (row < board.length - 1) {
            list.addAll(printAllPathsInList(p + "D", row + 1, col, board));
        }
        //going right
        if (col < board[0].length - 1) {
            list.addAll(printAllPathsInList(p + "R", row, col + 1, board));
        }
        //going left
        if (col > 0) {
            list.addAll(printAllPathsInList(p + "L", row, col - 1, board));
        }

        // this line is where the function will be over
        // so before the function gets removed, also remove the changes that were made by that function
        board[row][col] = true;

        return list;

    }
}
