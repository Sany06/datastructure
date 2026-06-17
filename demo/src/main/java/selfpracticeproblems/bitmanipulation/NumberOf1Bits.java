package selfpracticeproblems.bitmanipulation;

public class NumberOf1Bits {
    static void main(String[] args) {
         int n = 10;

         int count = 0;

         while (n > 0) {
             n = n & (n - 1);  // this step eliminates the rightmost set bit
             count++;
         }
        System.out.println(count);
    }
}
