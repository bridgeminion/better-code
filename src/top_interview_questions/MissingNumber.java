package top_interview_questions;

import java.util.Arrays;

/**
 * [0,1,3] index will be 0,1,2,3 ^ nums[0..2]
 */
public class MissingNumber {
    public int missingNumberXor(int[] nums) {
        int xor = nums.length;
        for (int i=0; i<nums.length; i++) {
            xor ^= i;
            xor ^= nums[i];
        }

        return xor;
    }

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }


}
