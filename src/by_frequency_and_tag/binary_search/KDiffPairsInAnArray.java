package by_frequency_and_tag.binary_search;

import java.util.HashSet;
import java.util.Set;

public class KDiffPairsInAnArray {
    public int findPairs(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        Set<Integer> zero = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num) && k == 0) {
                zero.add(num);
            }
        }
        if (k == 0) {
            return zero.size();
        }
        for (int num : set) {
            if (set.contains(num + k)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        KDiffPairsInAnArray app = new KDiffPairsInAnArray();
        System.out.println(app.findPairs(nums, 0));
    }

}
