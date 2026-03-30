package selfpracticeproblems.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PhonePad {
    static void main(String[] args) {
        List<String> list = new ArrayList<>();
        padRet("","23",list);
        System.out.println(list);
    }

    static void padRet(String p, String up, List<String> list) {
        if (up.isEmpty()) {
            list.add(p);
            return;
        }
        String[] map = {
                "", "", "abc", "def", "ghi", "jkl",
                "mno", "pqrs", "tuv", "wxyz"
        };

        int digit = up.charAt(0) - '0';
        String letters = map[digit];

        for (int i = 0; i < letters.length(); i++) {
            char c = letters.charAt(i);
            padRet(p + c, up.substring(1), list);
        }

    }
}
