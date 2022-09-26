package contest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Contest6049 {
    public int countDistinct(int[] nums, int k, int p) {
        int m = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        for (int i=0; i<m; i++) {
            helper(nums, 0, i, k, p, m, new ArrayList<>(), set);
        }

        return set.size();
    }

    public void helper(int[] nums, int count, int index, int k, int p, int m, List<Integer> list, Set<List<Integer>> set) {
        if (nums[index] % p == 0) {
            count++;
            if (count <= k) {
                list.add(nums[index]);
                set.add(new ArrayList(list));
            } else {
                return;
            }
        } else {
            list.add(nums[index]);
            set.add(new ArrayList(list));
        }
        if (index < m-1) {
            helper(nums, count, index+1, k, p, m, list, set);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,3,3,2,2};
        Contest6049 app = new Contest6049();
        app.countDistinct(nums, 2,2);
    }
}
