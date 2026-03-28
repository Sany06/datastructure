package com.example.demo.chatgpt.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        addParent(list, "", n, n);
        return list;
    }

    void addParent(List<String> result, String p, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(p);
            return;
        }

        if (left > 0) {
            addParent(result, p + "(", left - 1, right);
        }

        if (right > left) {
            addParent(result, p + ")", left, right - 1);
        }
    }
}
