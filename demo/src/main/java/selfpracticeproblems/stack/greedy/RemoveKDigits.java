package selfpracticeproblems.stack.greedy;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {

        StringBuilder sb = new StringBuilder();

        // we will traverse all the chars in the num and append it in the stringbuilder.
        // If the current num is less than the last num of the sb then we will delete that num
        for (int i = 0; i < num.length(); i++) {

            while(k > 0 && sb.length() > 0 && sb.charAt(sb.length() - 1) > num.charAt(i)) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            sb.append(num.charAt(i));
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
