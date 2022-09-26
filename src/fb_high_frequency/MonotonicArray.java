package fb_high_frequency;

public class MonotonicArray {
    public boolean isMonotonic(int[] A) {
        boolean inc = true, dec = true;
        for (int i = 1; i < A.length; ++i) {
            inc &= A[i - 1] <= A[i];
            dec &= A[i - 1] >= A[i];
        }
        return inc || dec;
    }

    public static void main(String[] args) {
        MonotonicArray app = new MonotonicArray();
        int[] nums = {1,1,12,13,12};
        System.out.println(app.isMonotonic(nums));
    }
}
