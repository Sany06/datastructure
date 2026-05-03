package selfpracticeproblems.stack.undooperation;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        return buildStr(s).equals(buildStr(t));
    }

    private String buildStr(String s) {
        StringBuilder sb =new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c != '#') {
                sb.append(c);
            } else if (!sb.isEmpty()){
                sb.deleteCharAt(sb.length() -  1);
            }
        }
        return sb.toString();
    }
}
