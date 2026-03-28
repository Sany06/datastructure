package selfpracticeproblems.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Dice {
    static void main(String[] args) {
        List<String> list = new ArrayList<>();
        calculate("", 4, list);
        //System.out.println(list);
        System.out.println(calculate("",5));
    }

    public static void calculate(String p, int target, List<String> result) {
        if (target == 0) {
            result.add(p);
            return;
        }

        for (int i = 1; i <= 6 && i <= target; i++) {
            calculate(p + i, target - i, result);
        }
    }

    public static List<String> calculate(String p, int target) {
        if (target == 0) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        List<String> list = new ArrayList<>();

        for (int i = 1; i <= 6 && i <= target; i++) {
            list.addAll(calculate(p + i, target - i));
        }
        return list;
    }
}
