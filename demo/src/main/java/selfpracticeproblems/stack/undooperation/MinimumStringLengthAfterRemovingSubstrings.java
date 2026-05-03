package selfpracticeproblems.stack.undooperation;

public class MinimumStringLengthAfterRemovingSubstrings {
    public int minLength(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            int len = sb.length();

            if (len > 0) {
                char last = sb.charAt(len - 1);

                if ((last == 'A' && c == 'B') ||
                        (last == 'C' && c == 'D')) {
                    sb.deleteCharAt(len - 1); // remove pair
                    continue;
                }
            }

            sb.append(c);
        }

        return sb.length();
    }
}
