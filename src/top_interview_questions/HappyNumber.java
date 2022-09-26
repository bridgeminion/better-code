package top_interview_questions;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy1(int n) {
        Set<Integer> seen = new HashSet<>();
        int total;

        while (seen.add(n)) {
            total = 0;
            while (n != 0) {
                total += Math.pow(n%10, 2);
                n /= 10;
            }
            if (total == 1) {
                return true;
            }
            n = total;
        }

        return false;
    }

    // use Floyd cycle detection
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = getTotal(slow);
            fast = getTotal(fast);
            fast = getTotal(fast);
        } while (slow != fast);
        return slow == 1;
    }

    private int getTotal(int n) {
        int total = 0;
        while (n != 0) {
            total += Math.pow(n%10, 2);
            n /= 10;
        }

        return total;
    }
}
