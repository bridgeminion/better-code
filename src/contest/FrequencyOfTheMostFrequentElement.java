package contest;

import java.util.Arrays;
import java.util.Collections;

public class FrequencyOfTheMostFrequentElement {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int max = 0;

        for (int i= nums.length-1; i>=0; i--) {
            int sum = 0, j = i-1;
            while (sum <= k && j >= 0) {
                sum += nums[i] - nums[j];
                j--;
            }
            if (sum > k) {
                max = Math.max(max, i-j-1);
            } else {
                max = Math.max(max, i - j);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        FrequencyOfTheMostFrequentElement instance = new FrequencyOfTheMostFrequentElement();
        int[] nums = {3,9,6};
        System.out.println(instance.maxFrequency(nums, 2));
    }

}
