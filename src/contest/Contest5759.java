package contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Contest5759 {
    int total = 0;
    List<List<Integer>> list = new ArrayList<>();
    public int subsetXORSum(int[] nums) {
        Arrays.sort(nums);
        helper(nums, list, new ArrayList<>(), 0, 0);
        return 0;
    }

    private void helper(int[] nums, List<List<Integer>> list, List<Integer> current, int index, int sum) {
        list.add(new ArrayList<>(current));
        total += sum;
        for (int i=index; i<nums.length; i++) {
            current.add(nums[i]);
            helper(nums, list, current, i+1, sum ^ nums[i]);
            current.remove(current.size() - 1);
        }

    }

    public static void main(String[] args) {
        Contest5759 instance = new Contest5759();
        int[] nums = {1,3};
        instance.subsetXORSum(nums);
    }

}
