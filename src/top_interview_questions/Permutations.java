package top_interview_questions;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, new ArrayList<>(), result);

        return result;
    }

    private void helper(int[] nums, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
        } else {
            for (int i=0; i<nums.length; i++) {
                if (list.contains(nums[i])){
                    continue;
                }
                list.add(nums[i]);
                helper(nums, list, result);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Permutations instance = new Permutations();
        int[] nums = {1,2,3};
        System.out.println(instance.permute(nums));
    }

}
