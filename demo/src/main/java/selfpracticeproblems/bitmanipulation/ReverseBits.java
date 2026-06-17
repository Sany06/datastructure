package selfpracticeproblems.bitmanipulation;

public class ReverseBits {
    static void main(String[] args) {
        int n = 123;
        System.out.println(reversebits(n));
    }

    private static int reversebits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= (n & 1);
            n >>>= 1;
        }
        return result;
    }
}
