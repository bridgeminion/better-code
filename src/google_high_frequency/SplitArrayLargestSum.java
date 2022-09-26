package google_high_frequency;

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        int sum = 0, max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        int start = max, end = sum;
        while (start + 1 < end) {
            int mid = (start + end) >>> 1;
            if (isValid(mid, nums, m)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        if (isValid(start, nums, m)) {
            return start;
        }
        return end;
    }

    private boolean isValid(int sum, int[] nums, int m) {
        int total = 0;
        for (int num : nums) {
            total += num;
            if (total > sum) {
                total = num;
                m--;
                if (m <= 0) {
                    return false;
                }
            }
        }
        return true;
    }

}
