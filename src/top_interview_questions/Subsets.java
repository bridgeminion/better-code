package top_interview_questions;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), result);

        return result;
    }

    // no need for stop condition, once for loop is done it will stop
    private void helper(int[] nums, int index, List<Integer> list, List<List<Integer>> result) {
        result.add(new ArrayList<>(list));
        for (int i=index; i<nums.length; i++) {
            list.add(nums[i]);
            helper(nums, i+1, list, result);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        Subsets instance = new Subsets();
        int[] nums = {1,2,3};
        System.out.println(instance.subsets(nums));
    }

}
