package high_frequency.basic_dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, result, new ArrayList<>(), 0, 0);

        return result;
    }

    private void helper(int[] candidates, int target, List<List<Integer>> result, List<Integer> list, int sum, int index) {
        if (sum == target) {
            result.add(new ArrayList(list));
            return;
        }
        if (sum < target) {
            for (int i=index; i<candidates.length; i++) {
                list.add(candidates[i]);
                helper(candidates, target, result, list, sum+candidates[i], i);
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum instance = new CombinationSum();
        int[] candidates = {2,3,6,7};
        System.out.println(instance.combinationSum(candidates, 7));
    }

}
