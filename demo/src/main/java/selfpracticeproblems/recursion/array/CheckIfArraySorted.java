package selfpracticeproblems.recursion.array;

public class CheckIfArraySorted {
    static void main(String[] args) {
        //int[] arr = {1, 2, 3, 4, 5};
        int[] arr={2,1,3};
        System.out.println(checkSorted(arr, 1));
    }

    private static boolean checkSorted(int[] arr, int index) {
        if (index == arr.length - 1) {
            return true;
        }
        if (arr[index] > arr[index - 1]) {
            return checkSorted(arr, index + 1);
        }
        return false;
    }
}
