package contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountNodesWithHighestScore {
    long max = 0;
    public int countHighestScoreNodes(int[] parents) {
        List<Integer>[] tree = new List[parents.length];
        Map<Integer, Long> map = new HashMap<>();
        for (int i=1; i<parents.length; i++) {
            if (tree[parents[i]] == null) {
                tree[parents[i]] = new ArrayList<>();
            }
            tree[parents[i]].add(i);
        }
        helper(tree, 0, map);
        int count = 0;
        for (long value : map.values()) {
            if (value == max) {
                count++;
            }
        }

        return count;
    }

    private long helper(List<Integer>[] tree, int index, Map<Integer, Long> map) {
        if (tree[index] == null) {
            max = Math.max(max, tree.length - 1);
            map.put(index, (long)tree.length - 1);
            return 1;
        }
        long result = 1, sum = 0, count = 0;
        for (int i : tree[index]) {
            count = helper(tree, i, map);
            sum += count;
            result *= count;
        }
        if (++sum < tree.length) {
            result *= tree.length - sum;
        }
        max = Math.max(max, result);
        map.put(index, result);
        return sum;
    }

    public static void main(String[] args) {
        CountNodesWithHighestScore app = new CountNodesWithHighestScore();
        int[] parents = {-1,2,0,2,0};
        System.out.println(app.countHighestScoreNodes(parents));
    }

}
