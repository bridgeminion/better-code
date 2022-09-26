package top_interview_questions;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean sameSign = (dividend ^ divisor) >= 0;
        int d1 = Math.abs(dividend);
        int d2 = Math.abs(divisor);
        int result = 0;
        while (d1 - d2 >= 0) { // can not do d1 >= d2
            int tmp = d2;
            int count = 1;
            while (d1 - (tmp << 1) >= 0) { // can not do d1 >= (tmp << 1)
                tmp <<= 1;
                count <<= 1;
            }
            d1 -= tmp;
            result += count;
        }

        return sameSign ? result : -result;
    }

    public static void main(String[] args) {
        DivideTwoIntegers instance = new DivideTwoIntegers();
        System.out.println(instance.divide(2147483647, 1));
    }

}
