package selfpracticeproblems.bitmanipulation;

public class FindKthBitInNthBinaryString {
    static void main(String[] args) {
        System.out.println(findithBit(10, 2));
    }

    private static int findithBit(int n, int i) {
        return (n >> i) & 1;
    }

}
