package top_interview_questions;

public class ReverseBits {
    public int reverseBits(int n) {
        int result = 0;
        for (int i=0; i<32; i++) {
            result = result << 1 | n&1; //n&1: last bit, result << 1: left shift one
            n >>= 1;
        }

        return result;
    }

}
