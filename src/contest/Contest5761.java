package contest;

import java.util.HashMap;
import java.util.Map;

public class Contest5761 {
    static class FindSumPairs {
        int[] nums1;
        int[] nums2;
        Map<Integer, Integer> map1, map2;

        public FindSumPairs(int[] nums1, int[] nums2) {
            this.nums1 = nums1;
            this.nums2 = nums2;
            map1 = new HashMap<>();
            map2 = new HashMap<>();
            for (int num : nums1) {
                map1.put(num, map1.getOrDefault(num, 0) + 1);
            }
            for (int num : nums2) {
                map2.put(num, map2.getOrDefault(num, 0) + 1);
            }
        }

        public void add(int index, int val) {
            int oldValue = nums2[index];
            if (map2.get(oldValue) == 1) {
                map2.remove(oldValue);
            } else {
                map2.put(oldValue, map2.get(oldValue) - 1);
            }
            nums2[index] += val;
            map2.put(nums2[index], map2.getOrDefault(nums2[index], 0) + 1);
        }

        public int count(int tot) {
            int count = 0;
            for (int num : nums1) {
                int needed = tot - num;
                if (map2.containsKey(needed)) {
                    count += map2.get(needed);
                }
             }

            return count;
        }
    }

    public static void main(String[] args) {
        Contest5761 instance = new Contest5761();
        int[] nums1 = {1, 1, 2, 2, 2, 3};
        int[] nums2 = {1, 4, 5, 2, 5, 4};
        FindSumPairs fp = new FindSumPairs(nums1, nums2);
        System.out.println(fp.count(7));
        fp.add(3, 2);
        System.out.println(fp.count(8));
        System.out.println(fp.count(4));
        fp.add(0,1);
        fp.add(1, 1);
        System.out.println(fp.count(7));
    }

}
