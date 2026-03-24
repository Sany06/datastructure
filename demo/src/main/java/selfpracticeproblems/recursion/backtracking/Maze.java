package selfpracticeproblems.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Maze {
    static void main() {
        System.out.println(mazecount(3, 3));
        //System.out.println(findPaths("",3,3));
        //System.out.println(findPathsDiagonal("", 3, 3));
        boolean[][] maze = {
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };
        System.out.println(findPathsHavingObstruction("", 0, 0, maze));
    }

    //follow  processed and unprocessed method
    static int mazecount(int row, int column) {
        if (row == 1 || column == 1) {
            return 1;
        }

        int left = mazecount(row - 1, column);
        int right = mazecount(row, column - 1);
        return left + right;
    }

    //Here we will only go Right and Down
    static List<String> findPaths(String p, int r, int col) {
        if (r == 1 && col == 1) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> list = new ArrayList<>();

        if (r > 1) {
            list.addAll(findPaths(p + "D", r - 1, col));
        }
        if (col > 1) {
            list.addAll(findPaths(p + "R", r, col - 1));
        }
        return list;
    }

    // Here we will go Right, Down and Diagonal
    static List<String> findPathsDiagonal(String p, int r, int col) {
        if (r == 1 && col == 1) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> list = new ArrayList<>();

        if (r > 1 && col > 1) {
            list.addAll(findPathsDiagonal(p + "D", r - 1, col - 1));
        }

        if (r > 1) {
            list.addAll(findPathsDiagonal(p + "V", r - 1, col));
        }
        if (col > 1) {
            list.addAll(findPathsDiagonal(p + "H", r, col - 1));
        }
        return list;
    }

    static List<String> findPathsHavingObstruction(String p, int r, int c, boolean[][] maze) {
        if (r == maze.length-1 && c == maze[0].length-1) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        List<String> list = new ArrayList<>();

        if (!maze[r][c]) {
            return list;
        }

        if (r < maze.length - 1) {
            list.addAll(findPathsHavingObstruction(p + "D", r + 1, c, maze));
        }
        if (c < maze[0].length - 1) {
            list.addAll(findPathsHavingObstruction(p + "R", r, c + 1, maze));
        }
        return list;
    }
}
