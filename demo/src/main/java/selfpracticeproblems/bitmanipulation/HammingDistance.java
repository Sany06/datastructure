package selfpracticeproblems.bitmanipulation;

public class HammingDistance {
    static void main(String[] args) {
        System.out.println(findHammingDist(1,4));
    }

    private static int findHammingDist(int x, int y) {
        int xor = x^y;
        int count = 0;

        while(xor > 0) {
            xor = xor & (xor - 1);  //remove the rightmost set bit
            count++;
        }

        return count;

    }
}
