package selfpracticeproblems.bitmanipulation;

public class PowerOfTwo {
    static void main(String[] args) {
        int n = 16;
        boolean flag = n > 0 && (n & (n - 1)) == 0;
        System.out.println(flag);
    }
}
