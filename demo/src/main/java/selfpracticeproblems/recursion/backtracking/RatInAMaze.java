package selfpracticeproblems.recursion.backtracking;

import java.util.ArrayList;

public class RatInAMaze {
    public ArrayList<String> ratInMaze(int[][] maze) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return calculate("",0,0, maze, visited);
    }

    ArrayList<String> calculate(String p, int r , int col, int[][]maze,boolean[][] visited) {
        if( r < 0 || r >= maze.length || col < 0 || col >= maze[0].length) {
            return new ArrayList<>();
        }

        ArrayList<String> list = new ArrayList<>();

        if(maze[r][col] == 0 || visited[r][col]) {
            return list;
        }

        if(r == maze.length - 1 && col == maze[0].length - 1) {
            list.add(p);
            return list;
        }

        visited[r][col] = true;


        list.addAll(calculate(p + "D", r + 1, col, maze,visited));

        list.addAll(calculate(p + "L", r , col - 1, maze,visited));

        list.addAll(calculate(p + "R", r , col + 1, maze,visited));

        list.addAll(calculate(p + "U", r - 1, col, maze,visited));



        visited[r][col] = false;
        return list;
    }
}
