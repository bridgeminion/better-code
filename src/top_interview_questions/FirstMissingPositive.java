package top_interview_questions;

/**
 * [1..n]
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            // if nums[i] in range, and nums[i] != nums[nums[i]-1]
            while (nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[nums[i]-1]) {
                int tmp = nums[i];
                nums[i] = nums[nums[i]-1];
                nums[tmp-1] = tmp;
            }
        }
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != i+1) {
                return i+1;
            }
        }

        return nums[nums.length - 1] + 1;
    }

    public static void main(String[] args) {
        FirstMissingPositive instance = new FirstMissingPositive();
        int[] nums = {1, 1};
        System.out.println(instance.firstMissingPositive(nums));
    }

}
