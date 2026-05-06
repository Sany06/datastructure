package selfpracticeproblems.stack.stackdesign;

public class DesignStackWithIncrementOperation {
    int[] arr;
    int currIndex;

    public DesignStackWithIncrementOperation(int maxSize) {
        arr = new int[maxSize];
        this.currIndex = 0;
    }

    public void push(int x) {
        if (currIndex < arr.length){
            arr[currIndex] = x;
            currIndex++;
        }

    }

    public int pop() {
        if (currIndex == 0) return -1;

        currIndex--;
        int pop = arr[currIndex];
        arr[currIndex] = 0;

        return pop;

    }

    public void increment(int k, int val) {
        int minIndex = Math.min(currIndex, k);
        for(int i = 0; i < minIndex; i++) {
            arr[i] = arr[i] + val;
        }
    }
}
