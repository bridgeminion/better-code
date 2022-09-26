package google_high_frequency;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<>();
        for (int n : asteroids) {
            if (n > 0) {
                stack.push(n);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && -n > stack.peek()) {
                    stack.pop();
                }
                if (!stack.isEmpty() && -n == stack.peek()) {
                    stack.pop();
                } else if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(n);
                }
            }
        }

        int[] a = stack.stream().sorted().mapToInt(i->i).toArray();
        int[] result = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            result[i++] = stack.pollLast();
        }

        return result;
    }

    public static void main(String[] args) {
        AsteroidCollision app = new AsteroidCollision();
//        int[] nums = {-2,-2,1,-2};
        int[] nums = {2,5,10, -5};
        int[] result = app.asteroidCollision(nums);
    }
}
