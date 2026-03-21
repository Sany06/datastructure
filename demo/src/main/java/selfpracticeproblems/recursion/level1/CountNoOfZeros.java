package selfpracticeproblems.recursion.level1;

public class CountNoOfZeros {
    static void main(String[] args) {
        System.out.println(countZeros(20200, 0));
    }

    static int countZeros(int n, int count) {
        if (n == 0) {
            return count;
        }
        if (n % 10 == 0) {
            count++;
        }
        return countZeros(n / 10, count);
    }
}
