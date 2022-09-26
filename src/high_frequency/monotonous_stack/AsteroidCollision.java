package high_frequency.monotonous_stack;

import java.util.*;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> deque = new LinkedList<>();
        for (int asteroid : asteroids) {
            if (asteroid < 0) {
                while (!deque.isEmpty() && deque.peek() > 0 && deque.peek() < -asteroid) {
                    deque.pop();
                }
                if (!deque.isEmpty() && deque.peek() == -asteroid) {
                    deque.pop();
                } else if (deque.isEmpty() || deque.peek() < 0) {
                    deque.push(asteroid);
                }
            } else {
                deque.push(asteroid);
            }
        }

        return  deque.stream().sorted(Comparator.reverseOrder()).mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        AsteroidCollision instance = new AsteroidCollision();
        int[] asteroids = {8, -8,9,8};
        instance.asteroidCollision(asteroids);
    }

}
