package selfpracticeproblems.recursion.level1;

public class ReverseDigits {
    static void main() {
        System.out.println(rev(12, 0));
    }

    static int rev(int n, int reversed) {
        if (n == 0) {
            return reversed;
        }

        int rem = n % 10;

        reversed = reversed * 10 + rem;

        return rev(n / 10, reversed);
    }
}
