package top_interview_questions;

public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int result = 0, factor = 5;
        while (factor <= n) {
            result += n/factor;
            factor *= 5;
        }

        return result;
    }
}
