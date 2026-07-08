package selfpracticeproblems.arrays.greedy.part1;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int finalPos = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= finalPos) {
                finalPos = i;
            }
        }
        return finalPos == 0;
    }

    public boolean canJump1(int[] nums) {
        int maxReach = 0;

        for(int i = 0; i< nums.length; i++) {
            if (i>maxReach) {
                return true;
            }
            maxReach = Math.max(maxReach, i+nums[i]);
        }
        return true;
    }
}
