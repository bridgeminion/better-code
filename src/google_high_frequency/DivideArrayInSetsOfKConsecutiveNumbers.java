package google_high_frequency;

import java.util.Map;
import java.util.TreeMap;

public class DivideArrayInSetsOfKConsecutiveNumbers {
    public boolean isPossibleDivide(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 0) {
                continue;
            }
            int num = map.get(key);
            for (int i=1; i<k; i++) {
                if (map.getOrDefault(key+i, 0) < num) {
                    return false;
                }
                map.put(key+i, map.get(key+i) - num);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        DivideArrayInSetsOfKConsecutiveNumbers app = new DivideArrayInSetsOfKConsecutiveNumbers();
        int[] nums = {3,3,2,2,1,1};
        System.out.println(app.isPossibleDivide(nums, 3));
    }
}
