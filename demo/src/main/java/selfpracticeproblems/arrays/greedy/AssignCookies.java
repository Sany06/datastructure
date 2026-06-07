package selfpracticeproblems.arrays.greedy;

import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;

        int child = 0, cookie = 0;

        while (child < g.length && cookie < s.length) {
            if (g[child] <= s[cookie] ) {
                count++;
                child++;
            }
            cookie++;
        }
        return count;
    }
}
