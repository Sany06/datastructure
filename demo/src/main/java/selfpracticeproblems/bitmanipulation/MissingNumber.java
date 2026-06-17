package selfpracticeproblems.bitmanipulation;

public class MissingNumber {

    static void main(String[] args) {
        int[] arr = {0,1,3};

        int xor = arr.length;
        for (int i = 0 ; i< arr.length ; i++) {
            xor ^= i ^ arr[i];
        }
        System.out.println(xor);
    }

}
