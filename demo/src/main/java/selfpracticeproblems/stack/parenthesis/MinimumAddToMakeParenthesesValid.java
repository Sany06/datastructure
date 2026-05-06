package selfpracticeproblems.stack.parenthesis;

public class MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String s) {
        int openbrace = 0;
        int minBraceReqd = 0;

        for (char ch : s.toCharArray()) {
            if(ch == '(') {
                openbrace++;
            } else {
                if (openbrace > 0) {
                    openbrace--;
                } else {
                    minBraceReqd++;
                }
            }
        }
        return openbrace + minBraceReqd;

    }
}
