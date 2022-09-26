package contest;

import java.util.ArrayList;
import java.util.List;

public class Contest5904 {
    int count = 0;
    public int countMaxOrSubsets(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max |= num;
        }
        helper(nums, max, 0, new ArrayList<>(), 0);

        return count;
    }

    private void helper(int[] nums, int max, int index, List<Integer> list, int or) {
        if (or == max) {
            count++;
        }
        if (list.size() > nums.length) {
            return;
        }
        for (int i=index; i<nums.length; i++) {
            list.add(nums[i]);
            helper(nums, max, i+1, list, or | nums[i]);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Contest5904 app = new Contest5904();
        int[] nums = {3,1};
        System.out.println(app.countMaxOrSubsets(nums));
    }

}
