package selfpracticeproblems.recursion.level1;

public class SumOfDigits {
    static void main(String[] args) {
        System.out.println(9 % 10);
        System.out.println(9 / 10);
        System.out.println(sum(1324));
    }

    static int sum(int n) {
        if (n == 0) {
            return 0;
        }

        return (n % 10) + sum(n / 10);
    }
}
