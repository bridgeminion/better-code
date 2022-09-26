package top_interview_questions;

public class ReverseInteger {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            result = result * 10 + digit;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return 0;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ReverseInteger instance = new ReverseInteger();
        System.out.println((1 + 2147483647) / 2);
        System.out.println((1 + 2147483647) >>> 1);
        System.out.println(instance.reverse(1534236469));
    }

}
