package selfpracticeproblems.arrays.greedy.part2;
//https://leetcode.com/problems/next-permutation/description/
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //Find the pivot where pitot is nums[i] < nums[i + 1]
        // [1 ,3 , 5 , 4 , 2] here pivot is 3, we will do i-- till nums[i] >= nums[i + 1]
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        //Step-2
        //Find the first greatest number after i and swap it
        if (i >= 0) {
            int j = nums.length-1;
            while(j >= 0 && nums[j] <= nums[i]){
                j--;
            }
            swap(nums,i,j);
        }

        //Step-3
        //reverse the part after i
        reverse(nums,i+1,nums.length-1);

    }

    private void reverse(int[] nums, int i, int j) {
        while(i < j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] =  nums[j];
        nums[j] = temp;
    }
}
