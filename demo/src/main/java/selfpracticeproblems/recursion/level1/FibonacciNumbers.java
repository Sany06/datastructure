package selfpracticeproblems.recursion.level1;

public class FibonacciNumbers {
    static void main(String[] args) {
        System.out.println(fibo(6));
    }

    private static int fibo(int n) {
        if (n < 2) {
            return n;
        }
        return fibo(n - 1) + fibo(n - 2);
    }
}
