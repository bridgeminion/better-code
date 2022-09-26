package high_frequency.sort_first;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i=0; i<nums.length - 2; i++) {
            int first = nums[i];
            int left = i+1, right = nums.length - 1, sum = 0;
            while (left < right && left < nums.length && right < nums.length) {
                sum = nums[left] + nums[right] + first;
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
                if (Math.abs(target - sum) < Math.abs(target - result)) {
                    result = sum;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ThreeSumClosest instance = new ThreeSumClosest();
        int[] nums = {1,2,5,10,11   };
        System.out.println(instance.threeSumClosest(nums, 12));
    }

}
