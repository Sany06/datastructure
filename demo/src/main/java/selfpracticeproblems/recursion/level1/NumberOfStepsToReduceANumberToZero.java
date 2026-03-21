package selfpracticeproblems.recursion.level1;

public class NumberOfStepsToReduceANumberToZero {
    static void main(String[] args) {
        System.out.println(count(14,0));
    }

    public static int count(int num,int c){
        if(num==0){
            return c;
        }
        if (num%2==0){
            return count(num/2,c+1);
        } else {
            return count(num-1,c+1);
        }
    }
}
