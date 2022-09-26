package contest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Contest5894 {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> set1 = new HashSet();
        for (int num : nums1) {
            set1.add(num);
        }
        Set<Integer> set2 = new HashSet();
        for (int num : nums2) {
            set2.add(num);
        }
        Set<Integer> set3 = new HashSet();
        for (int num : nums3) {
            set3.add(num);
        }
        for (int num : set2) {
            if (!set1.add(num)) {
                result.add(num);
            }
        }
        for (int num : set3) {
            if (!set1.add(num)) {
                result.add(num);
            }
        }

        return new ArrayList(result);
    }

}
