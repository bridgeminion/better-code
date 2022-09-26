package by_frequency_and_tag.dfs;

import java.util.HashMap;
import java.util.Map;

public class SolvingQuestionsWithBrainpower {
    int max = 0;
    public long mostPoints(int[][] questions) {
        Map<Integer, Integer> memo = new HashMap<>();
        dfs(questions, 0, 0, memo);

        return max;
    }

    private int dfs(int[][] questions, int index, int sum, Map<Integer, Integer> memo) {
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        if (index >= questions.length) {
            max = Math.max(max, sum);
            memo.put(index, sum);
            return sum;
        }
        int[] question = questions[index];
        int route1 = dfs(questions, index + question[1] + 1, sum + question[0], memo);
        int route2 = dfs(questions, index+1, sum, memo);
        memo.put(index, Math.max(route1, route2));
        return Math.max(route1, route2);
    }

    public static void main(String[] args) {
        SolvingQuestionsWithBrainpower app = new SolvingQuestionsWithBrainpower();
        int[][] questions = {{12,46},{78,19},{63,15},{79,62},{13,10}};
        System.out.println(app.mostPoints(questions));
    }
}
