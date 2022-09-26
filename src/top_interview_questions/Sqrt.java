package top_interview_questions;

/**
 * use division instead of mid * mid to avoid overflow
 *
 */
public class Sqrt {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int start = 1, end = x;
        while (start + 1 < end) {
            int mid = (start + end) >>> 1;
            if (x/mid >= mid) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }

        if (x/end >= end) {
            return end;
        }
        return start;
    }

    public static void main(String[] args) {
        Sqrt instance = new Sqrt();
        System.out.println(instance.mySqrt(10));
    }

}
