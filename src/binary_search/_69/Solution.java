package binary_search._69;

public class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int left = 1, right = x;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (x/mid >= mid) {
                left = mid;
            } else {
                right = mid;
            }
        }
        // Check right first as we want largest possible value
        if (x/right >= right) {
            return right;
        }
        return left;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(0));
    }

}
