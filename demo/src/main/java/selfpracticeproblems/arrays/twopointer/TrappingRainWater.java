package selfpracticeproblems.arrays.twopointer;

public class TrappingRainWater {
    static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap1(arr));
    }

    // this  has TC : O(n)  SC : O(1)
    public static int trap1(int[] height) {
        int capacity = 0;
        int left = 0;
        int right= height.length - 1;
        int leftMax = 0;
        int rightMax = 0;

        while (left < right){
            if (height[left] > leftMax) {
                leftMax = height[left];
            }
            if (height[right] > rightMax) {
                rightMax = height[right];
            } //If leftMax < rightMax, the water is completely determined by leftMax, so process left. Otherwise, process right.
            if (leftMax < rightMax) {
                capacity += leftMax - height[left];
                left++;
            } else {
                capacity += rightMax - height[right];
                right--;
            }
        }
        return capacity;
    }


    // this  has TC : O(n) but SC : O(n)
    public static int trap(int[] height) {
        int capacity = 0;
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];


        //We are creating the leftMax array
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        //We are creating the rightMax array
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        for (int i = 0; i < n; i++) {
            capacity += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return capacity;
    }
}
