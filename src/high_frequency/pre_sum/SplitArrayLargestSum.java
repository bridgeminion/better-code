package high_frequency.pre_sum;

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        int max = 0, sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }
        int start = max, end = sum, min = sum;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (isValid(nums, mid, m)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    private boolean isValid(int[] nums, int target, int m) {
        int sum = 0, count = 1;
        for (int num : nums) {
            sum += num;
            if (sum > target) {
                sum = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SplitArrayLargestSum instance = new SplitArrayLargestSum();
        int[] nums = {7,2,5,10,8};
        System.out.println(instance.splitArray(nums, 2));
    }

}
