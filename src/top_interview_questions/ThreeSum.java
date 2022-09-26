package top_interview_questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * when calling twoSum, dedup
 * dedup in twoSum
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++) {
            // DEDUP
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            result.addAll(twoSum(nums, i+1, nums.length - 1, 0-nums[i], nums[i]));
        }

        return result;
    }

    private List<List<Integer>> twoSum(int[] nums, int start, int end, int target, int firstElement) {
        List<List<Integer>> result = new ArrayList<>();
        while (start < end) {
            if (nums[start] + nums[end] > target) {
                end--;
            } else if (nums[start] + nums[end] < target) {
                start++;
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(firstElement);
                list.add(nums[start]);
                list.add(nums[end]);
                result.add(list);
                // DEDUP
                while (start < nums.length && nums[start] == nums[start+1]) {
                    start++;
                }
                while (end >= 0 && nums[end] == nums[end-1]) {
                    end--;
                }
                start++;
                end--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ThreeSum instance = new ThreeSum();
        int[] nums = {-1,0,1,2,-1,-4};
        instance.threeSum(nums);
    }
}
