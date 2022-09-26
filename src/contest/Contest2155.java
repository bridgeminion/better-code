package contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Contest2155 {
    public List<Integer> maxScoreIndices(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int m = nums.length;
        int[] left = new int[m+1];
        int[] right = new int[m+1];
        int k=1, q=m-1, leftSum = 0, rightSum = 0;
        for (int i=0; i<m; i++) {
            leftSum += nums[i] == 0 ? 1 : 0;
            rightSum += nums[m-i-1];
            left[k++] = leftSum;
            right[q--] = rightSum;
        }
        int max = 0;
        for (int i=0; i<=m; i++) {
            max = Math.max(max, left[i] + right[i]);
            map.putIfAbsent(left[i] + right[i], new ArrayList<>());
            map.get(left[i] + right[i]).add(i);
        }

        return map.get(max).stream().map(i->i).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Contest2155 app = new Contest2155();
        int[] nums = {0,0,1,0};
        System.out.println(app.maxScoreIndices(nums));
    }

}
