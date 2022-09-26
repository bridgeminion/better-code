package high_frequency.pre_sum;

import java.util.*;

/**
 * skip if equals to previous one for both 3sum and 2sum
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0; i<nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int first = nums[i];
            List<List<Integer>> twoSums = twoSum(nums, i+1, nums.length - 1, 0 - first);
            if (!twoSums.isEmpty()) {
                twoSums.forEach(list -> list.add(first));
                result.addAll(twoSums);
            }
        }
        return result;
    }

    private List<List<Integer>> twoSum(int[] nums, int start, int end, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int left = start, right = end;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[left]);
                list.add(nums[right]);
                result.add(list);
                while (left < right && nums[left] == nums[left+1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right-1]) {
                    right--;
                }
                left++;
                right--;
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ThreeSum instance = new ThreeSum();
        int[] nums = {-2,0,0,2,2};
        List<List<Integer>> result = instance.threeSum(nums);
    }

}
