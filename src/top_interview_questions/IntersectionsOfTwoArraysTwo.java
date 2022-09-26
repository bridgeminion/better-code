package top_interview_questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntersectionsOfTwoArraysTwo {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] result = new int[nums2.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int i = 0;
        for (int num : nums2) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num)-1);
                if (map.get(num) == 0) {
                    map.remove(num);
                }
                result[i++] = num;
            }
        }

        return Arrays.copyOf(result, i);
    }

}
