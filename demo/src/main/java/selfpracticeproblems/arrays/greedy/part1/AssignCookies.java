package selfpracticeproblems.arrays.greedy.part1;

import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;

        int greed = 0, cookie = 0;

        while (greed < g.length && cookie < s.length) {
            if (g[greed] <= s[cookie] ) {
                count++;
                greed++;
            }
            cookie++;
        }
        return count;
    }
}
