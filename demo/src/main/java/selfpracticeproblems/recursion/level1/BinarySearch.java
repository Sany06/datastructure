package selfpracticeproblems.recursion.level1;

public class BinarySearch {

    static void main(String[] args) {
        int[] arr={-1,0,3,5,9,12};
        System.out.println(binarySearch(0,arr.length-1,arr,0));
    }

    static int binarySearch(int start,int end, int[] arr,int target){
        if (start>end){
            return -1;
        }
        int mid=start+(end-start)/2;

        if (arr[mid]==target){
            return mid;
        }
        if (target>arr[mid]){
           return binarySearch(mid+1, arr.length-1,arr,target);
        } else {
           return binarySearch(0,mid-1,arr,target);
        }
    }
}
