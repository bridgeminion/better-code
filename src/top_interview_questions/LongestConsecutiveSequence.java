package top_interview_questions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            if (!set.contains(num-1)) {
                int start = num;
                while (set.contains(start)) {
                    start++;
                }
                max = Math.max(max, start - num);
            }
        }

        return max;
    }

}
