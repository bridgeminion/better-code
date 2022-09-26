package top_interview_questions;

import java.util.HashMap;
import java.util.Map;

public class FourSumTwo {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                map.put(n1 + n2, map.getOrDefault(n1 + n2, 0) + 1);
            }
        }
        int result = 0;
        for (int n3 : nums3) {
            for (int n4 : nums4) {
                int needed = -(n3 + n4);
                result += map.getOrDefault(needed, 0);
            }
        }

        return result;
    }

}
