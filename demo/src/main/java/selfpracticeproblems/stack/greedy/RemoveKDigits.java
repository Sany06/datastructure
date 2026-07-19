package selfpracticeproblems.stack.greedy;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {

        StringBuilder sb = new StringBuilder();

        // we will traverse all the chars in the num and append it in the stringbuilder.
        // If the current digit is less than the last digit of the sb then we will delete that digit
        for (int i = 0; i < num.length(); i++) {
            char digit = num.charAt(i);
            while(k > 0 && sb.length() > 0 && sb.charAt(sb.length() - 1) > digit) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            sb.append(digit);
        }

        //for num like 12345 where the last digit is always less than the next digit
        while( k > 0 &&  sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }

        //for handling cases like 00123
        int start = 0;
        while (start < sb.length() && sb.charAt(start)  == '0') {
            start++;
        }

        String result = sb.substring(start);

        return result.isEmpty() ? "0" : result;
    }
}
