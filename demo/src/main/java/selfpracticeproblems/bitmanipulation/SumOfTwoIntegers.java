package selfpracticeproblems.bitmanipulation;

public class SumOfTwoIntegers {
    static void main(String[] args) {
        int a = 5, b = 7;
        System.out.println(findsum(a, b));
    }

    private static int findsum(int a, int b) {

        while (b != 0) {
            int carry = (a & b) << 1;  // carry bits
            a = a ^ b;                  // sum without carry
            b = carry;               // carry becomes the next number to add
        }
        return a;
    }
}
