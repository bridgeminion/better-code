package top_interview_questions;

public class StringToInteger {
    public int myAtoi(String s) {
        int result = 0, i = 0;
        boolean isNegative = false;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            isNegative = s.charAt(i) == '-';
            i++;
        }
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && s.charAt(i)-'0' > 7)) {
                if (isNegative) {
                    return Integer.MIN_VALUE;
                }
                return Integer.MAX_VALUE;
            }
            result = result * 10 + s.charAt(i)-'0';
            i++;
        }

        return isNegative ? -result : result;
    }

    public static void main(String[] args) {
        StringToInteger instance = new StringToInteger();
        System.out.println(instance.myAtoi("21474836460"));
    }

}
