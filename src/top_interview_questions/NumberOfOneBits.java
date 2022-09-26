package top_interview_questions;

public class NumberOfOneBits {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1; // use unsigned bit shift
        }

        return count;
    }

}
