package by_frequency_and_tag.backtracking;

import java.util.HashSet;
import java.util.Set;

public class BeautifulArrangement {
    int sum = 0;
    public int countArrangement(int n) {
        helper(n, 1, new HashSet<>());

        return sum;
    }

    private void helper(int n, int index, Set<Integer> set) {
        if (index == n+1) {
            sum++;
            return;
        }
        for (int i=1; i<=n; i++) {
            if (!set.contains(i) && isValid(i, index)) {
                set.add(i);
                helper(n, index+1, set);
                set.remove(i);
            }
        }
    }

    private boolean isValid(int num, int i) {
        return num % i == 0 || i % num == 0;
    }

    public static void main(String[] args) {
        BeautifulArrangement app = new BeautifulArrangement();
        System.out.println(app.countArrangement(2));
    }
}
